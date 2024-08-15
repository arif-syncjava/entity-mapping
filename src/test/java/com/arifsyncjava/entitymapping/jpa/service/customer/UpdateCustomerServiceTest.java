package com.arifsyncjava.entitymapping.jpa.service.customer;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.customer.service.UpdateCustomerService;
import com.arifsyncjava.entitymapping.jpa.entity.Address;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import org.assertj.core.api.Assertions;
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
public class UpdateCustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private UpdateCustomerService updateCustomerService;

    @Test
    public void updateCustomerService_returnsSuccess () {

        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail("mohammadarif123000@gmail.com");
        request.setCity("sylhet");
        request.setCityZone("pathantula");


        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setEmail(request.getEmail());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setCityZone(request.getCityZone());

        customer.setAddress(address);

        when(customerRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(customer));

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        ResponseEntity<CustomerDTO> response = updateCustomerService.execute(request);

        assertThat(response.getStatusCode().isSameCodeAs(HttpStatus.OK));
        assertThat(response.getBody().getEmail())
                .isEqualTo("mohammadarif123000@gmail.com");



    }

    @Test
    public void updateCustomerService_returnsException () {

        String email = "mohammadarif123000@gmail.com";

        RegistrationForm request = new RegistrationForm();
        request.setUsername("arif");
        request.setEmail(email);
        request.setCity("sylhet");
        request.setCityZone("pathantula");


        when(customerRepository.findByEmail(email)).thenReturn(Optional.empty());

        ResourceNotFoundException exception =
                assertThrows(ResourceNotFoundException.class,
                        ()-> updateCustomerService.execute(request));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.NOT_FOUND));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Customer not found with requested email");



    }






}
