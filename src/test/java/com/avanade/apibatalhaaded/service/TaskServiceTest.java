package com.avanade.apibatalhaaded.service;

import com.avanade.apibatalhaaded.model.Personagem;
import com.avanade.apibatalhaaded.repository.PersonagemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class TaskServiceTest {

	@InjectMocks
	private PersonagemService service;

	@Mock
	private PersonagemRepository repository;

	List<Personagem> taskList;

//	@BeforeEach
//	void setUp( ) {
//		MockitoAnnotations.openMocks( this );
//		taskList = new ArrayList<>( );
//		Personagem task1 = new Personagem( 1L, "Configurar Mockito", "Configurar os mocks para teste unitário",
//							   false, LocalDateTime.now( ), null );
//		Personagem task2 = new Personagem( 2L, "Criar testes unitários",
//							   "Configurar chamadas de teste unitário", false, LocalDateTime.now( ),
//							   null );
//		taskList.add( task1 );
//		taskList.add( task2 );
//	}

//	@Test
//	void create( ) {
//		Personagem task = new Personagem( 1L, "Configurar Mockito", "Configurar os mocks para teste unitário",
//							  true, LocalDateTime.now( ), LocalDateTime.now( ) );
//		Personagem expected = new Personagem( 1L, "Configurar Mockito",
//								  "Configurar os mocks para teste unitário", false,
//								  LocalDateTime.now( ), null );
//		when( repository.save( task ) ).thenReturn( task );
//		Personagem response = service.create( task );
//		Assertions.assertEquals( expected.getIsCompleted( ), response.getIsCompleted( ) );
//		verify( repository, times( 1 ) ).save( any( ) );
//	}

	@Test
	void findAll( ) {
		when( repository.findAll( ) ).thenReturn( taskList );
		List<Personagem> tasks = service.findAll( );
		Assertions.assertEquals( tasks, taskList );
		verify( repository, times( 1 ) ).findAll( );
	}

	@Test
	void findById( ) {
		when( repository.findById( any( ) ) ).thenReturn(
				Optional.ofNullable( taskList.get( 0 ) ) );
		Personagem task = service.findById( 1L );
		Assertions.assertEquals( task, taskList.get( 0 ) );
		verify( repository, times( 1 ) ).findById( any( ) );
	}

//	@Test
//	void delete( ) {
//		doNothing( ).when( repository ).deleteById( any( ) );
//		service.delete( 1L );
//		verify( repository, times( 1 ) ).deleteById( any( ) );
//	}

//	@Test
//	void update( ) {
//		Personagem task = taskList.get( 0 );
//		task.setIsCompleted( true );
//		task.setCompletedAt( LocalDateTime.now( ) );
//		when( repository.save( task ) ).thenReturn( task );
//		Personagem response = service.update( task );
//		Assertions.assertEquals( task.getIsCompleted( ), response.getIsCompleted( ) );
//		verify( repository, times( 1 ) ).save( any( ) );
//	}
}