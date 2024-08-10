package com.arifsyncjava.entitymapping.jpa.customer.repository;

import com.arifsyncjava.entitymapping.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
