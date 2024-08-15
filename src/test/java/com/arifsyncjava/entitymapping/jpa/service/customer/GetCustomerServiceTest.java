package com.arifsyncjava.entitymapping.jpa.service.customer;

import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.customer.service.GetCustomerService;
import com.arifsyncjava.entitymapping.jpa.entity.Address;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetCustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private GetCustomerService getCustomerService;

    @Test
    public void getCustomerService_returnsSuccess () {

        String email = "mohammadarif123000@gmail.com";
       Customer customer = new Customer();
        customer.setUsername("arif");
        customer.setEmail(email);

        Address address = new Address();
        address.setCity("dhaka");
        address.setCityZone("unknown");

        customer.setAddress(address);

        when(customerRepository.findByEmail(email)).thenReturn(Optional.of(customer));

        ResponseEntity<CustomerDTO> response = getCustomerService.execute(email);

        Assertions.assertThat(response.getStatusCode().is2xxSuccessful());
        Assertions.assertThat(response.getBody().getEmail())
                .isEqualTo("mohammadarif123000@gmail.com");


    }

    @Test
    public void getCustomerService_returnsException () {

        String email = "mohammadarif123000@gmail.com";
        when(customerRepository.findByEmail(email)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class, ()->getCustomerService.execute(email));

        Assertions.assertThat(exception.getStatus().is4xxClientError());
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Customer not found with requested email");

    }



}
