package com.arifsyncjava.entitymapping.jdbc.rowmapper;

import com.arifsyncjava.entitymapping.dto.response.AddressDTO;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDTORowMapper implements RowMapper<CustomerDTO> {

    @Override
    public CustomerDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUsername(resultSet.getString("username"));
        customerDTO.setEmail(resultSet.getString("email"));

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(resultSet.getString("city"));
        addressDTO.setCityZone(resultSet.getString("city_zone"));

        customerDTO.setAddressDTO(addressDTO);

        return customerDTO;
    }


}
