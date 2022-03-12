package com.financiero.test.dtoResponse;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class dtoResponseCrear implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7448421736583291252L;
	/**
	 * 
	 */
	@JsonProperty("numero_cuenta")
    Long numeroCuenta;
	
	@JsonProperty("fecha_creacion")
    Date fechaCreacion;
	
	@JsonProperty("saldo_inicial")
    Long saldoInicial;
	
	@JsonProperty("nombre")
    String nombre;
	
	@JsonProperty("apellido")
	String apellido;

}
