package com.arifsyncjava.entitymapping.jdbc.repository.customer;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepository;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;

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

    @Test
    public void CustomerRepository_read_ReturnACustomerDTO () {
        // Arrange
        String email = "unique@gmail.com";
        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        // Act
        Optional<CustomerDTO> customerDTO
                = customerJdbcRepository.read(email);

        // Assert - verify
        Assertions.assertThat(customerDTO.get().getUsername())
                .isEqualTo("arif");

    }



    @Test
    public void CustomerRepository_update_ReturnACustomerDTO () {
        // Arrange
        // old Record
        RegistrationForm request = new RegistrationForm();
        String email = "aemail@gmail.com";
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        // new Record
        RegistrationForm updateRequest = new RegistrationForm();
        updateRequest.setUsername("newArif");
        updateRequest.setEmail(email);
        updateRequest.setCity("newSylhet");
        updateRequest.setCityZone("newPathantula");

        // Act

        CustomerDTO customerDTO = customerJdbcRepository.update(updateRequest);

        // Assert

        Assertions.assertThat(customerDTO.getUsername())
                .isEqualTo("newArif");
        Assertions.assertThat(customerDTO.getAddressDTO().getCityZone())
                .isEqualTo("newPathantula");


    }


    @Test // InvalidArgument Exception
    public void CustomerRepository_update_ReturnException () {
        // old Record
        RegistrationForm request = new RegistrationForm();
        String email = "oldemail@gmail.com";
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        // new Record
        RegistrationForm updateRequest = new RegistrationForm();
        updateRequest.setUsername("newArif");
        updateRequest.setEmail("nonexistemail");
        updateRequest.setCity("newSylhet");
        updateRequest.setCityZone("newPathantula");

        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                ()->customerJdbcRepository.update(updateRequest));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Email not found. try again with new email");

    }


    @Test   // DataAccess Exception
    public void CustomerRepository_update_ReturnAnotherException () {
        // old Record
        RegistrationForm request = new RegistrationForm();
        String email = "oldemail@gmail.com";
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        // new Record
        RegistrationForm updateRequest = new RegistrationForm();
        updateRequest.setUsername("newArif");
        updateRequest.setEmail(email);
        updateRequest.setCity(null);  // arise Exception
        updateRequest.setCityZone("newPathantula");

        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                ()->customerJdbcRepository.update(updateRequest));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("An error occur to perform database operation");

    }

    @Test
    public void  CustomerRepository_delete_ReturnSuccess () {
        RegistrationForm request = new RegistrationForm();
        String email = "mohamaad@gmail.com";
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        customerJdbcRepository.delete(email);
        Optional<CustomerDTO> customerDTO = customerJdbcRepository.read(email);

        Assertions.assertThat(customerDTO).isEmpty();

    }

    @Test
    public void  CustomerRepository_delete_ReturnException () {
        RegistrationForm request = new RegistrationForm();
        String email = "mohamaad@gmail.com";
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");
        customerJdbcRepository.create(request);

        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                ()->  customerJdbcRepository.delete("nonexistEmail"));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));

        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Email not found. try again with new email");




    }










}
