package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financiero.test.models.Contacto;


@Repository
public interface ContactoRepository  extends JpaRepository<Contacto,Integer>{

}
