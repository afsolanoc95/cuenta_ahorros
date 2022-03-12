package com.financiero.test.dtoResponse;

import java.io.Serializable;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class dtoResponseGeneral implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4032089777327282407L;

	
	@JsonProperty("message")
    String message;
}
