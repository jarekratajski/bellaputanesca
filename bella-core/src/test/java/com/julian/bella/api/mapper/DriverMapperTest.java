package com.julian.bella.api.mapper;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.mapper.DriverMapper;
import com.julian.bella.domain.Driver;

public class DriverMapperTest {

	EmployeeMapperTest<Driver, DriverDto, DriverMapper> emplTest;
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.emplTest = new EmployeeMapperTest<Driver, DriverDto, DriverMapper> (Driver.class, DriverDto.class, DriverMapper.class);
	}
	
	@Test 
	public void testNullAndEmpty() {
		emplTest.testNullAndEmpty();
	}
	
	@Test
	public void testSourceToDto() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException   {
		emplTest.testSourceToDto();
	}
	
	@Test
	public void testDtoToNewSource() throws InstantiationException, IllegalAccessException {
		emplTest.testDtoToNewSource();
	}
	
	@Test
	public void testDtoUpdateFromSource() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException  {
		emplTest.testDtoUpdateFromSource();
	}
}
