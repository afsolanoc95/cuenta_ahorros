package com.financiero.test.models;

import java.util.Date;

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
@Table(name="cuenta")
public class Cuenta {
	
	@Id
	@Column(unique=true)
	private Long numero;
	
	@Column(nullable=false)
	private Long saldo;
	
	@Column(nullable=false)
	private Date fechaCreacion;
}
