package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class TestUserRepository 
{
	
	
	@Autowired
	UserRepository repository;
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
}
