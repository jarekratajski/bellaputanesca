package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.bella.api.dto.AddressDto;
import com.julian.bella.api.mapper.AddressMapper;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.domain.Address;

public class AddressMapperTest {

	GenericMapper<Address, AddressDto> mapper;
	
	@Before
	public void setUp() {
		this.mapper = new AddressMapper();
	}
	
	@Test 
	public void testNullAndEmpty() throws InstantiationException, IllegalAccessException {
		MapperTestGlobal<Address, AddressDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
		mtg.testEmpty(mapper, AddressDto.class);
	}
	
	@Test
	public void testSourceToDto() throws JsonProcessingException  {
		// given
		ObjectMapper jackson = new ObjectMapper();
		Address address = new Address("a", "b", "c", "00-001");
		
		// when
		AddressDto dto = mapper.sourceToDto(address);
		String dtoJson = jackson.writeValueAsString(dto);
	
		// then
		assertEquals("{\"city\":\"a\",\"street\":\"b\",\"houseNumberEtc\":\"c\",\"postalCode\":\"00-001\"}", dtoJson);
	}
	
	@Test
	public void testDtoToNewSource() {
		// given
		AddressDto dto = new AddressDto();
		dto.setCity("a").setHouseNumberEtc("1b").setStreet("c").setPostalCode("00-001");
		
		// when
		Address addressFromDto = mapper.dtoToNewSource(dto);
		
		// then
		assertEquals("a", addressFromDto.city);
		assertEquals("1b", addressFromDto.houseNumberEtc);
		assertEquals("c", addressFromDto.street);
		assertEquals("00-001", addressFromDto.postalCode);
	}
}
