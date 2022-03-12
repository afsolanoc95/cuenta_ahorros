package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financiero.test.models.CuentaPersona;

public interface CuentaPersonaRepository extends JpaRepository<CuentaPersona,Integer>{

	//@Query(value = "select * from cuenta_persona where numero_cuenta=?1", nativeQuery = true)
	//CuentaPersona findAllcuentaPersonaNumero(Long numeroCuenta);
}
