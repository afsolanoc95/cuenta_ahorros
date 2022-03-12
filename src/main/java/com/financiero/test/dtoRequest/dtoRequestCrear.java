package com.financiero.test.dtoRequest;


import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Component
public class dtoRequestCrear implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5378111398014558487L;
	@JsonProperty("cedula")
	private Long cedula;
	@JsonProperty("saldo")
	private Long saldo;
	@JsonProperty("telefono")
	private String telefono;
	@JsonProperty("telefono_secundario")
	private String telefono2;
	@JsonProperty("email")
	private String email;
	@JsonProperty("email_secundario")
	private String email2;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("apellido")
	private String apellido;
	@JsonProperty("edad")
	private Integer edad;
}
