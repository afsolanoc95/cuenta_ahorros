package com.financiero.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Component
@Table(name="persona")
public class Persona {
	
	@Id
	@Column(nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column(nullable=false)
	 private Integer edad;
	
	
	
}
