package com.avanade.apibatalhaaded.service;

import com.avanade.apibatalhaaded.exception.InvalidInputException;
import com.avanade.apibatalhaaded.exception.ResourceNotFoundException;
import com.avanade.apibatalhaaded.model.Personagem;
import com.avanade.apibatalhaaded.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonagemService {

	@Autowired
	private PersonagemRepository repository;

	public Personagem create(Personagem personagem ) {
		personagem.setCreatedAt( LocalDateTime.now( ) );
		return this.repository.save( personagem );
	}

	public List<Personagem> findAll( ) {
		return repository.findAll( );
	}

	public Personagem findById(Long id ) {
		return repository.findById( id )
						 .orElseThrow( ( ) -> new ResourceNotFoundException(
								 "Task not found with ID: " + id ) );
	}

	public void delete( Long id ) {
		repository.deleteById( id );
	}

	public Personagem update(Personagem personagem ) {
		if ( personagem.getId( ) == null ) {
			throw new InvalidInputException( "There is no ID" );
		}
		return repository.save( personagem );
	}
}
