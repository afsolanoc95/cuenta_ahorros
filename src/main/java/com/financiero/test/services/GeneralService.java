package com.financiero.test.services;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.financiero.test.dtoRequest.dtoRequestCrear;
import com.financiero.test.dtoRequest.dtoRequestTransaccion;
import com.financiero.test.dtoResponse.dtoResponseCrear;
import com.financiero.test.dtoResponse.dtoResponseGeneral;
import com.financiero.test.models.Contacto;
import com.financiero.test.models.Cuenta;
import com.financiero.test.models.CuentaPersona;
import com.financiero.test.models.Persona;
import com.financiero.test.models.Transaccion;
import com.financiero.test.repositories.ContactoRepository;
import com.financiero.test.repositories.CuentaPersonaRepository;
import com.financiero.test.repositories.CuentaRepository;
import com.financiero.test.repositories.PersonaRepository;
import com.financiero.test.repositories.TransaccionRepository;

@Service
public class GeneralService {


	PersonaRepository personaRepository;
	ContactoRepository contactoRepository;
	CuentaRepository cuentaRepository;
	CuentaPersonaRepository cuentaPersonaRepository;
	TransaccionRepository transaccionRepository;
	
	@Autowired
	Persona persona;
	@Autowired
	Cuenta cuenta;
	@Autowired
	CuentaPersona cuentaPersona;

	
	
	@Autowired
	dtoResponseCrear response;
	@Autowired
	dtoResponseGeneral responseGeneral;
	
	@Value("${com.saldo.minimo}")
	Integer valorMinimo;
	
	@Value("${com.respuesta.saldo}")
	String saldo;
	
	@Value("${com.respuesta.transaccion}")
	String tranRealizada;
	
	public GeneralService(PersonaRepository personaRepository,ContactoRepository contactoRepository,CuentaRepository cuentaRepository,CuentaPersonaRepository cuentaPersonaRepository,TransaccionRepository transaccionRepository) {
		this.personaRepository=personaRepository;
		this.contactoRepository=contactoRepository;
		this.cuentaRepository=cuentaRepository;
		this.cuentaPersonaRepository=cuentaPersonaRepository;
		this.transaccionRepository=transaccionRepository;
	}
	public Optional<Cuenta> consultar(String numeroCuenta){
		return   this.cuentaRepository.findById(Long.parseLong(numeroCuenta));
	}
	
	public dtoResponseGeneral consignar(dtoRequestTransaccion consignacion) {
		
		try {
			
			Transaccion transaccion=new Transaccion();
			transaccion.setFecha(new Date());
			transaccion.setNumeroCuenta(consignacion.getNumeroCuenta());
			transaccion.setMovimiento(consignacion.getValor());
			Optional<Cuenta> cuenta=cuentaRepository.findById(transaccion.getNumeroCuenta());
			cuenta.get().setSaldo(cuenta.get().getSaldo()+consignacion.getValor());
			this.cuentaRepository.save(cuenta.get());
			this.transaccionRepository.save(transaccion);
			this.responseGeneral.setMessage(this.tranRealizada);
			return responseGeneral;
		}catch(Exception e) {
			 responseGeneral.setMessage(e.getMessage());
			System.out.println(e.getMessage());
			return responseGeneral;
		}
		
	}
	
	public dtoResponseGeneral retiro(dtoRequestTransaccion retiro) {
		try {
			Optional<Cuenta> cuenta=cuentaRepository.findById(retiro.getNumeroCuenta());
			if(cuenta.get().getSaldo()>=retiro.getValor()) {
				Transaccion transaccion=new Transaccion();
				transaccion.setFecha(new Date());
				transaccion.setNumeroCuenta(retiro.getNumeroCuenta());
				transaccion.setMovimiento(retiro.getValor()*-1);
				cuenta.get().setSaldo(cuenta.get().getSaldo()-retiro.getValor());
				this.cuentaRepository.save(cuenta.get());
				this.transaccionRepository.save(transaccion);
				this.responseGeneral.setMessage(this.tranRealizada);
				return responseGeneral;
			}else {
				responseGeneral.setMessage(this.saldo);
				return responseGeneral;
			}
		}catch(Exception e) {
			 responseGeneral.setMessage(e.getMessage());
			System.out.println(e.getMessage());
			return responseGeneral;
		}
	}
	
	
	public dtoResponseCrear create(dtoRequestCrear create){
		Contacto contacto =new Contacto();
		Contacto contacto2 =new Contacto();
		Random numAleatorio = new Random();	
		Long numCuenta=(long) 0;

		if(create.getSaldo()>=this.valorMinimo) {
			if(this.personaRepository.findById(create.getCedula()).isEmpty()) {
				this.persona.setId(create.getCedula());
				this.persona.setNombre(create.getNombre());
				this.persona.setApellido(create.getApellido());
				this.persona.setEdad(create.getEdad());
				this.personaRepository.save(this.persona);
				contacto.setPersonaId(create.getCedula());
				contacto.setEmail(create.getEmail());
				contacto.setTelefono(create.getTelefono());
				this.contactoRepository.save(contacto);
				if(!(create.getTelefono2().isEmpty())|| !(create.getEmail2().isEmpty()) ) {
					if(create.getTelefono2().isEmpty()) {
						create.setTelefono2(null);
					}
					if(create.getEmail2().isEmpty()) {
						create.setEmail2(null);
					}
					contacto2.setPersonaId(create.getCedula());
					contacto2.setEmail(create.getEmail2());
					contacto2.setTelefono(create.getTelefono2());
					this.contactoRepository.save(contacto2);
				}
				numCuenta=create.getCedula()+(numAleatorio.nextInt(999-100+1) + 100);
				this.cuenta.setNumero(numCuenta);
				this.cuenta.setFechaCreacion(new Date());
				this.cuenta.setSaldo(create.getSaldo());
				this.cuentaRepository.save(this.cuenta);
				this.cuentaPersona.setNumeroCuenta(numCuenta);
				this.cuentaPersona.setPersonaId(create.getCedula());
				this.cuentaPersonaRepository.save(this.cuentaPersona);
			}else {
				numCuenta=create.getCedula()+(numAleatorio.nextInt(999-100+1) + 100);
				this.cuenta.setNumero(numCuenta);
				this.cuenta.setFechaCreacion(new Date());
				this.cuenta.setSaldo(create.getSaldo());
				this.cuentaRepository.save(this.cuenta);
				this.cuentaPersona.setNumeroCuenta(numCuenta);
				this.cuentaPersona.setPersonaId(create.getCedula());
				this.cuentaPersonaRepository.save(this.cuentaPersona);
			}
			this.response.setNumeroCuenta(numCuenta);
			this.response.setFechaCreacion(new Date());
			this.response.setSaldoInicial(create.getSaldo());
			this.response.setNombre(create.getNombre());
			this.response.setApellido(create.getApellido());
			
		}else {
			this.response=null;
		}
		return   this.response;
	}
}
