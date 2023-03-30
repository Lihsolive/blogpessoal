package com.generation.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();

		usuarioRepository.save(new Usuario(0L, "João Gabriel Silva", "jbiel@email.com", "jmap123456",
				"https://i.imgur.com/FETvs20.jpg"));

		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "drisilva@email.com", "jmap123456",
				"https://i.imgur.com/NtyGneo.jpg"));

		usuarioRepository.save(
				new Usuario(0L, "Manuela Alves", "manua@email.com", "jmap123456", "https://i.imgur.com/mB3VM2N.jpg"));

		usuarioRepository.save(new Usuario(0L, "Paulo Silva", "silva.paulo@email.com", "jmap123456",
				"http://i.imgur.com/JR7kUFU.jpg"));
	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornaUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("jbiel@email.com");
		assertTrue(usuario.get().getUsuario().equals("jbiel@email.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João Gabriel da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Adriana da Silva"));
		assertTrue(listaDeUsuarios.get(3).getNome().equals("Paulo Silva"));
	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}
