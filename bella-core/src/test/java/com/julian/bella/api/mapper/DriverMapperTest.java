package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.mapper.DriverMapper;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.domain.Driver;
import com.julian.bella.rodo.HashMD5;

public class DriverMapperTest {

	GenericMapper<Driver, DriverDto> mapper;

	final String DEFAULT_NAME = "testname";
	final String DEFAULT_NAME2 = "testname2";
	final String DEFAULT_LAST_NAME = "testlastname";
	final String DEFAULT_LAST_NAME2 = "testlastname2";
	final String DEFAULT_PESEL = "92071314764";
	
	@Before
	public void setUp() {
		UserMapper userMapper = new UserMapper();
	    this.mapper = new DriverMapper(userMapper);
	}

	public DriverDto getDefaultDto() {
		DriverDto dto = new DriverDto();
		dto.setFirstName(DEFAULT_NAME).setLastName(DEFAULT_LAST_NAME).setPesel(DEFAULT_PESEL).setActive(true);
		return dto;
	}

	public Driver getDefaultSource() {
		Driver s = new Driver(DEFAULT_PESEL, DEFAULT_NAME2, DEFAULT_LAST_NAME2, true);
		return s;
	}

	@Test
	public void testNullAndEmpty() {
		MapperTestGlobal<Driver, DriverDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
	}

	@Test
	public void testSourceToDto() {
		// given
		Driver source = getDefaultSource();

		// when
		DriverDto dto = mapper.sourceToDto(source);

		// then
		assertEquals(DEFAULT_NAME2, dto.getFirstName());
		assertEquals(DEFAULT_LAST_NAME2, dto.getLastName());
		assertTrue(dto.isActive());
	}

	@Test
	public void testDtoToNewSource() {
		// given
		DriverDto dto = getDefaultDto();

		// when
		Driver source = mapper.dtoToNewSource(dto);

		// then
		assertNotNull(source.peselEncrypted);
		assertEquals(HashMD5.getHashed(DEFAULT_PESEL), source.peselEncrypted);
		assertEquals(DEFAULT_NAME, source.getFirstName());
		assertEquals(DEFAULT_LAST_NAME, source.getLastName());
		assertTrue(source.isActive());
	}

	@Test
	public void testDtoUpdateFromSource() {
		// given
		Driver source = getDefaultSource();
		source.setActive(false);
		DriverDto dto = getDefaultDto();

		// when
		Driver newSource = mapper.dtoToUpdatedSource(source, dto);

		// then
		assertNotNull(newSource.peselEncrypted);
		assertEquals(HashMD5.getHashed(DEFAULT_PESEL), newSource.peselEncrypted);
		assertEquals(DEFAULT_NAME, newSource.getFirstName());
		assertEquals(DEFAULT_LAST_NAME, newSource.getLastName());
		assertTrue(newSource.isActive());
	}
}
