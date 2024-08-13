package com.arifsyncjava.entitymapping;

public interface JdbcRepository<I,O>{
    O execute (I input);
}
