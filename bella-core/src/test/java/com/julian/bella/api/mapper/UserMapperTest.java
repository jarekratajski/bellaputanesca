package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.domain.User;

public class UserMapperTest {
	
	GenericMapper<User, UserDto> mapper;
	
	@Before
	public void setUp() {
		this.mapper = new UserMapper();
	}
	
	@Test 
	public void testNullAndEmpty() throws InstantiationException, IllegalAccessException {
		MapperTestGlobal<User, UserDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
		mtg.testEmpty(mapper, UserDto.class);
	}

	@Test
	public void testSourceToDto() {
		// given
		ObjectMapper jackson = new ObjectMapper();
		String login = "a";
		User u = new User();
		u.setLogin(login);
		u.setEmail("email@email.com");
		
		// when
		UserDto dto = mapper.sourceToDto(u);
		String dtoJson = "";
		try {
			dtoJson = jackson.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			fail();
		}
		
		// then
		assertEquals("{\"login\":\"a\",\"email\":\"email@email.com\"}", dtoJson);
	}

	@Test
	public void testDtoToNewSource() {
		// given
		String login = "a";
		UserDto dto = new UserDto();
		dto.setLogin(login);
		
		// when
		User u = mapper.dtoToNewSource(dto);
				
		// then
		assertEquals(login, u.getLogin());
	}

	@Test
	public void testDtoToUpdatedSource() {
		// given
		String login = "a";
		String email = "aaa@aaa.com";
		
		User oldUser = new User();
		oldUser.setEmail(email);
		
		UserDto dto = new UserDto();
		dto.setLogin(login);
		dto.setEmail("newEmail@new.com");
		
		// when
		User newUser = mapper.dtoToUpdatedSource(oldUser, dto);
		
		// then
		assertEquals(login, newUser.getLogin());
		assertEquals("newEmail@new.com", newUser.getEmail());
	}
}
