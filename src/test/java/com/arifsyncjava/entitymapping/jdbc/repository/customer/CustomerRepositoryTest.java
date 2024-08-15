package com.arifsyncjava.entitymapping.jdbc.repository.customer;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepository;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.junit.jupiter.api.Assertions.assertThrows;


@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    private CustomerJdbcRepository customerJdbcRepository;
    private JdbcClient jdbcClient;

    @Autowired
    public CustomerRepositoryTest(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
        customerJdbcRepository = new CustomerJdbcRepositoryImpl(jdbcClient);
    }


    @Test
    public void  create_returnsSuccess () {
        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail("unique@gmail.com");
        request.setCity("sylhet");
        request.setCityZone("pathantula");

        CustomerDTO customerDTO = customerJdbcRepository.create(request);

        Assertions.assertThat(customerDTO).isNotNull();
        Assertions.assertThat(customerDTO.getEmail())
                .isEqualTo("unique@gmail.com");

    }

    @Test
    public void  create_returnException () {
        RegistrationForm request = new RegistrationForm();
        request.setUsername(null);  // arise Exception
        request.setEmail("mohammadarif2300@gmail.com");
        request.setCity("sylhet");
        request.setCityZone("pathantula");

        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                ()-> customerJdbcRepository.create(request));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));

    }

    @Test
    public void emailExist_returnTrue () {
        String email = "mohammadarif@gmail.com";
        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);
        boolean b = customerJdbcRepository.emailExist(email);
        Assertions.assertThat(b).isTrue();
    }

    @Test
    public void emailExist_returnFalse () {
        String email = "mohammadarif@gmail.com";
        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);
        boolean b = customerJdbcRepository.emailExist("nonexistemail");
        Assertions.assertThat(b).isFalse();
    }


//    public void create_returnEmailAlreadyUsedException () {
//        RegistrationForm request = new RegistrationForm();
//        request.setUsername("arif");
//        request.setEmail("mohammadarif2300@gmail.com");
//        request.setCity("sylhet");
//        request.setCityZone("pathantula");
//
//
//    }






}
