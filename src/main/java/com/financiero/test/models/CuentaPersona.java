package com.financiero.test.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Component
@Table(name="cuenta_persona")
public class CuentaPersona {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private Integer id;
	
	@Column(nullable=false)
	private Long numeroCuenta;
	
	@Column(nullable=false)
	private Long personaId;
}
