package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financiero.test.models.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,Long>{
	
}
