package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financiero.test.models.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion,Integer>{

}
