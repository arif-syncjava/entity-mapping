package com.arifsyncjava.entitymapping.jpa.service.customer;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.customer.service.CreateCustomerService;
import com.arifsyncjava.entitymapping.jpa.entity.Address;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CreateCustomerService createCustomerService;


    @Test
    public void createCustomerService_returnsSuccess () {

        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail("mohammadarif123000@gmail.com");
        request.setCity("sylhet");
        request.setCityZone("pathantula");

        when(customerRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.empty());

        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setEmail(request.getEmail());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setCityZone(request.getCityZone());

        customer.setAddress(address);

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        ResponseEntity<CustomerDTO> response = createCustomerService.execute(request);

        assertThat(response.getStatusCode().isSameCodeAs(HttpStatus.CREATED));
        assertThat(response.getBody().getEmail())
                .isEqualTo("mohammadarif123000@gmail.com");




    }

    @Test
    public void createCustomerService_returnsException () {
        RegistrationForm request = new RegistrationForm();
        request.setEmail("mohammadarif123000@gmail.com");

        when(customerRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(new Customer()));

        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                () -> createCustomerService.execute(request));


        assertThat(exception.getStatus().isSameCodeAs(HttpStatus.CREATED));
        assertThat(exception.getMessage())
                .isEqualTo("Email already used. try again with new email");

    }







}
