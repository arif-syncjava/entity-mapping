package com.arifsyncjava.entitymapping.jdbc.customer.repository;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.jdbc.model.Customer;
import com.arifsyncjava.entitymapping.jdbc.rowmapper.CustomerRowMapper;
import jakarta.transaction.Transactional;
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
    public Optional<Customer> create(RegistrationForm request) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.sql("")
                .param("city", request.getCity())
                .param("cityZone", request.getCityZone())
                .update(keyHolder);

        Long addressId = keyHolder.getKey().longValue();

        jdbc.sql("  ")
                .param("username", request.getUsername())
                .param("email", request.getEmail())
                .param("address_id",addressId)
                .update();

        return jdbc.sql(" ")
                .param("",)
                .query(new CustomerRowMapper()).optional();
    }

    @Override
    public Optional<Customer> read(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> update(RegistrationForm request) {
        return Optional.empty();
    }

    @Override
    public Void delete(String email) {
        return null;
    }
}
