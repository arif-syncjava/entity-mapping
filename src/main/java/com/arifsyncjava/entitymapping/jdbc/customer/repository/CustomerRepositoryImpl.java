package com.arifsyncjava.entitymapping.jdbc.customer.repository;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.rowmapper.CustomerDTORowMapper;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private final JdbcClient jdbc;

    public CustomerRepositoryImpl(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public CustomerDTO create(RegistrationForm request) {

        if (emailExist(request.getEmail())) {
            throw new InvalidArgumentException(
                    ErrorMessage.EMAIL_AlREADY_USED.getMessage());
        }

        try {
            KeyHolder addressKeyHolder = new GeneratedKeyHolder();
            jdbc.sql("INSERT INTO customer.address (city, city_zone) VALUES (:city, :cityZone)")
                    .param("city", request.getCity())
                    .param("cityZone", request.getCityZone())
                    .update(addressKeyHolder,"id");

            Long addressId = addressKeyHolder.getKeyAs(Long.class);

            jdbc.sql("INSERT INTO customer.customers (username,email,address_id) VALUES (:username,:email,:addressId)")
                    .param("username", request.getUsername())
                    .param("email", request.getEmail())
                    .param("addressId",addressId)
                    .update();

            return jdbc.sql("SELECT c.username,c.email,a.city,a.city_zone " +
                            "FROM customer.customers c JOIN customer.address a ON " +
                            "c.address_id = a.id WHERE c.address_id = :addressId ")
                    .param("addressId",addressId)
                    .query(new CustomerDTORowMapper()).single();

        } catch (DataAccessException exception) {
            throw new InvalidArgumentException(exception.getMessage());
        }


    }

    @Override
    public Optional<CustomerDTO> read(String email) {
        return jdbc.sql("SELECT c.username,c.email,a.city,a.city_zone " +
                        "FROM customer.customers c JOIN customer.address a ON " +
                        "c.address_id = a.id WHERE c.email = :email ")
                .param("email",email)
                .query(new CustomerDTORowMapper()).optional();
    }

    @Override
    public CustomerDTO update(RegistrationForm request) {

        if (!emailExist(request.getEmail())) {
            throw new InvalidArgumentException(
                    ErrorMessage.EMAIL_NOT_FOUND.getMessage());
        }

        try {

            jdbc.sql("UPDATE customer.customers " +
                            "SET username = : username , email = :email")
                    .param("username", request.getUsername())
                    .param("email", request.getEmail())
                    .update();

            Long addressId = jdbc
                    .sql("SELECT customers.address_id FROM customers WHERE email = :email " )
                    .param("email", request.getEmail())
                    .query(Long.class)
                    .single();

            jdbc.sql("UPDATE address SET city = :city, city_zone = :cityZone WHERE id = :addressId")
                    .param("city", request.getCity())
                    .param("cityZone", request.getCityZone())
                    .param("addressId",addressId)
                    .update();

            return jdbc.sql("SELECT c.username,c.email,a.city,a.city_zone " +
                            "FROM customer.customers c JOIN customer.address a ON " +
                            "c.address_id = a.id WHERE c.address_id = :addressId ")
                    .param("addressId",addressId)
                    .query(new CustomerDTORowMapper()).single();

        } catch (DataAccessException exception) {
            throw new InvalidArgumentException(exception.getMessage());
        }

    }

    @Override
    public void delete(String email) {
        if (!emailExist(email)) {
            throw new InvalidArgumentException(
                    ErrorMessage.EMAIL_NOT_FOUND.getMessage());
        }

        try {


            jdbc.sql("DELETE FROM customer.customers WHERE email = :email ")
                    .param("email", email).update();

            Long addressId = jdbc
                    .sql("SELECT customers.address_id FROM customers WHERE email = :email " )
                    .param("email", email)
                    .query(Long.class)
                    .single();

            jdbc.sql("DELETE FROM customer.address WHERE id = :addressId")
                    .param("addressId",addressId).update();


        } catch (DataAccessException exception) {
            throw new InvalidArgumentException(exception.getMessage());
        }


    }

    @Override
    public boolean emailExist(String email) {
        return jdbc.sql("SELECT EXISTS (SELECT 1 FROM customer.customers WHERE email = :email)")
                .param("email", email)
                .query(Boolean.class).single();

    }






}
