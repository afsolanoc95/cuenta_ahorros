package com.financiero.test.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financiero.test.dtoRequest.dtoRequestCrear;
import com.financiero.test.dtoRequest.dtoRequestTransaccion;
import com.financiero.test.dtoResponse.dtoResponseCrear;
import com.financiero.test.dtoResponse.dtoResponseGeneral;
import com.financiero.test.models.Cuenta;
import com.financiero.test.models.Persona;
import com.financiero.test.services.GeneralService;

@RestController
@RequestMapping("/Financiero")
public class GeneralController {


	GeneralService generalService;
	
	@Autowired
	dtoResponseGeneral responseSaldo;
	
	@Value("${com.saldo.minimo}")
	Integer valorMinimo;
	@Value("${com.respuesta.saldo.minimo}")
	String message;
	
	public GeneralController(GeneralService generalService) {
		this.generalService=generalService;
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Object> crear(RequestEntity<dtoRequestCrear> requestEntity){
		dtoResponseCrear response=generalService.create(requestEntity.getBody());
		if(response==null) {
			 this.responseSaldo.setMessage(this.message+this.valorMinimo);
			return  new ResponseEntity<Object>(this.responseSaldo, HttpStatus.OK);
		}else {
			return  new ResponseEntity<Object>(response, HttpStatus.OK);
		}
	}

	@PutMapping("/personaConsigna")
	public ResponseEntity<Object> consignar(RequestEntity<dtoRequestTransaccion> requestEntity){
		this.responseSaldo=generalService.consignar(requestEntity.getBody());
		return  new ResponseEntity<Object>(this.responseSaldo, HttpStatus.OK);
	}
	
	@PutMapping("/personaRetiro")
	public ResponseEntity<Object> retirar(RequestEntity<dtoRequestTransaccion> requestEntity){
		this.responseSaldo=generalService.retiro(requestEntity.getBody());
		return  new ResponseEntity<Object>(this.responseSaldo, HttpStatus.OK);
	}
	
	@GetMapping("/persona")
	public ResponseEntity<Object>  consulta(@RequestParam String numero){
		 Optional<Cuenta> cuenta=generalService.consultar(numero);
		 if(cuenta.isEmpty()) {
			 this.responseSaldo.setMessage("no existe cuenta con ese numero ");
		 }else {
			 this.responseSaldo.setMessage("su saldo es "+cuenta.get().getSaldo());
		 }
		return  new ResponseEntity<Object>(this.responseSaldo, HttpStatus.OK);
	}
	
}
