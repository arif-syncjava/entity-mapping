package com.arifsyncjava.entitymapping.jdbc.rowmapper;

import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jdbc.model.Address;
import com.arifsyncjava.entitymapping.jdbc.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<CustomerDTO> {

    @Override
    public CustomerDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customer.se



        return null;
    }
}
