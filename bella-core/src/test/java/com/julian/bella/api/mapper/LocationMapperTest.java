package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.bella.api.dto.AddressDto;
import com.julian.bella.api.dto.LocationDto;
import com.julian.bella.api.mapper.AddressMapper;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.api.mapper.LocationMapper;
import com.julian.bella.domain.Address;
import com.julian.bella.domain.Location;

public class LocationMapperTest {

	GenericMapper<Location, LocationDto> mapper;

	@Before
	public void setUp() {
		this.mapper = new LocationMapper(new AddressMapper());
}
	
	@Test 
	public void testNullAndEmpty() throws InstantiationException, IllegalAccessException {
		MapperTestGlobal<Location, LocationDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
	}
	
	@Test
	public void testSourceToDto() throws JsonProcessingException  {
		// given
		ObjectMapper jackson = new ObjectMapper();
		Address address = new Address("a", "b", "c", "00-001");
		Location location = new Location(address, 1, 2);
		
		// when
		LocationDto dto = mapper.sourceToDto(location);
		String dtoJson = jackson.writeValueAsString(dto);
	
		// then
		assertEquals("{\"address\":{\"city\":\"a\",\"street\":\"b\",\"houseNumberEtc\":\"c\",\"postalCode\":\"00-001\"},\"longitude\":1.0,\"latitude\":2.0}", dtoJson);
	}
	
	@Test
	public void testDtoToNewSource() {
		// given
		AddressDto addressDto = new AddressDto();
		addressDto.setCity("a").setHouseNumberEtc("1b").setStreet("c").setPostalCode("00-001");
		LocationDto dto = new LocationDto();
		dto.setAddress(addressDto).setLatitude(1).setLongitude(2);
				
		// when
		Location locationFromDto = mapper.dtoToNewSource(dto);
		
		// then
		assertEquals("a", locationFromDto.address.city);
		assertEquals("1b", locationFromDto.address.houseNumberEtc);
		assertEquals("c", locationFromDto.address.street);
		assertEquals("00-001", locationFromDto.address.postalCode);
		assertEquals(1, locationFromDto.latitude, 0);
		assertEquals(2, locationFromDto.longitude, 0);		
	}
}
