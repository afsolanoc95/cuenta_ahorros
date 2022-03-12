package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financiero.test.models.Persona;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona,Long>{

}
