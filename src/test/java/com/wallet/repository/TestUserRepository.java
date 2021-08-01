package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;



import com.wallet.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class TestUserRepository 
{
	private static final String EMAIL = "teste@gmail.com";
	
	@Autowired
	UserRepository repository;
	
	@BeforeEach
	public void setUp() {
		User u = new User();
		u.setName("Set up User");
		u.setPassword("Senha123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	@AfterEach
	public void tearDown() {
		
		repository.deleteAll();
	}
	
	@Test
	public void testSave()
	{
		User u = new User();
		u.setName("teste");
		u.setPassword("123456");
		u.setEmail("teste@gmail.com");
		assertNotNull(u.getEmail());
		
		
		User res = repository.save(u);
		
		assertNotNull(res);
		
	}
	
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
