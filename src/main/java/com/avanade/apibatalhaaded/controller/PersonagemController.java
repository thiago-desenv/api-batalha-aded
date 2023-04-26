package com.avanade.apibatalhaaded.controller;

import com.avanade.apibatalhaaded.model.Personagem;
import com.avanade.apibatalhaaded.service.PersonagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/apibatalhaaded" )
@Api( value = "Batalha ADED API REST" )
@CrossOrigin( origins = "*" )
public class PersonagemController {

	@Autowired
	private PersonagemService service;

	@GetMapping( "/personagens" )
	@ApiOperation( "Buscar um personagem" )
	public ResponseEntity< List<Personagem> > getAll( ) {
		return new ResponseEntity<>( service.findAll( ), HttpStatus.OK );
	}

	@GetMapping( "/personagens/{id}" )
	@ApiOperation( "Procurar um personagem pelo ID" )
	public ResponseEntity< Personagem > getById( @PathVariable( value = "id" ) Long personagemId ) {
		return new ResponseEntity<>( service.findById( personagemId ), HttpStatus.OK );
	}

	@PostMapping( "/personagens" )
	@ApiOperation( "Criar um personagem" )
	public ResponseEntity< Personagem > create( @RequestBody Personagem personagem ) {
		return new ResponseEntity<>( service.create( personagem ), HttpStatus.CREATED );
	}

	@PutMapping( "/personagens" )
	@ApiOperation( "Atualizar o personagem" )
	public ResponseEntity< Personagem > update( @RequestBody Personagem personagem ) {
		return new ResponseEntity<>( service.update( personagem ), HttpStatus.OK );
	}

	@DeleteMapping( "/personagens" )
	@ApiOperation( "Deletar o personagem" )
	public ResponseEntity< HttpStatus > update( @RequestHeader Long personagemId ) {
		service.delete(personagemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
