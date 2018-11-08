package com.julian.deliverp.api.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.deliverp.api.dto.AddressDto;
import com.julian.deliverp.api.dto.ClientDto;
import com.julian.deliverp.api.dto.UserDto;
import com.julian.deliverp.api.mapper.AddressMapper;
import com.julian.deliverp.api.mapper.ClientMapper;
import com.julian.deliverp.api.mapper.GenericMapper;
import com.julian.deliverp.api.mapper.UserMapper;
import com.julian.deliverp.domain.Address;
import com.julian.deliverp.domain.Client;
import com.julian.deliverp.domain.User;

public class ClientMapperTest {

	GenericMapper<Address, AddressDto> addressMapper;
	GenericMapper<User, UserDto> userMapper;
	GenericMapper<Client, ClientDto> mapper;
	
	@Before
	public void setUp() {
		this.addressMapper = new AddressMapper();
		this.userMapper = new UserMapper();
		this.mapper = new ClientMapper(addressMapper, userMapper);
	}
	
	@Test 
	public void testNullAndEmpty() throws InstantiationException, IllegalAccessException {
		MapperTestGlobal<Client, ClientDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
		mtg.testEmpty(mapper, ClientDto.class);
	}
	
	@Test
	public void testSourceToDto() throws JsonProcessingException  {
		// given
		ObjectMapper jackson = new ObjectMapper();
		Address address = new Address("a", "b", "1c", "00-001");
		User user = new User();
		user.setLogin("a");
		Client source = new Client("9492109373");
		source.setContactAddress(address);
		source.setUser(user);
		
		// when
		ClientDto dto = mapper.sourceToDto(source);
		String dtoJson = jackson.writeValueAsString(dto);
	
		// then //https://youtu.be/M-tqT7-sDG8?t=140
		assertEquals("{\"id\":null,\"login\":\"a\",\"nip\":\"9492109373\",\"companyName\":null,\"contactAddress\":{\"city\":\"a\",\"street\":\"b\",\"houseNumberEtc\":\"1c\",\"postalCode\":\"00-001\"},\"registerAddress\":null}", dtoJson);
	}
	
	@Test
	public void testDtoToNewSource() {
		// given
		String newCompanyName = "new comapny name";
		String newLogin = "new_login";
		UserDto userDto = new UserDto();
		userDto.setLogin(newLogin);
		
		ClientDto dto = new ClientDto();
		dto.setCompanyName(newCompanyName).setUser(userDto);
		
		// when
		Client sourceFromDto = mapper.dtoToNewSource(dto);

		// then
		assertEquals(newCompanyName, sourceFromDto.getCompanyName());
		assertEquals(newLogin, sourceFromDto.getUser().getLogin());
	}
}
