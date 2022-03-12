package com.financiero.test.dtoRequest;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
public class dtoRequestTransaccion  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8233425372940064756L;
	@JsonProperty("numero_cuenta")
	private Long numeroCuenta;
	@JsonProperty("valor")
	private Long valor;
}
