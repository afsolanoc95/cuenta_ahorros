package com.financiero.test.services;

import java.util.ArrayList;
import static java.util.Collections.emptyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.financiero.test.models.Usuario;
import com.financiero.test.repositories.UsuarioRepository;

@Service
public class UsuarioServicio implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;


	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
		
		//return new User("admin","admin",new ArrayList<>());
	}

}
