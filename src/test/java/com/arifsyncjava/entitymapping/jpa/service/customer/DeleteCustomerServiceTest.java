package com.arifsyncjava.entitymapping.jpa.service.customer;

import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.customer.service.DeleteCustomerService;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteCustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private DeleteCustomerService deleteCustomerService;

    @Test
    public void  deleteCustomerService_returnsSuccess () {
        String email = "mohammadarif123000@gmail.com";
        Customer savedCustomer = new Customer();
        savedCustomer.setEmail(email);
        savedCustomer.setAddress(new Address());

        when(customerRepository.findByEmail(email)).thenReturn(Optional.of(savedCustomer));

        ResponseEntity<Void> response = deleteCustomerService.execute(email);

        Assertions.assertThat(response.getBody()).isNull();
        Assertions.assertThat(response.getStatusCode()
                .isSameCodeAs(HttpStatus.NO_CONTENT));


    }




    @Test
    public void  deleteCustomerService_returnsException () {
        String email = "mohammadarif123000@gmail.com";

        when(customerRepository.findByEmail(email)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
        ()->deleteCustomerService.execute(email));

        Assertions.assertThat(exception.getStatus().isSameCodeAs(HttpStatus.NOT_FOUND));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Customer not found with requested email");


    }




}
