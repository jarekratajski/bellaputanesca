package com.julian.bella.api.mapper;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.api.mapper.ShipperMapper;
import com.julian.bella.domain.Shipper;

public class ShipperMapperTest {

	EmployeeMapperTest<Shipper, ShipperDto, ShipperMapper> emplTest;
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.emplTest = new EmployeeMapperTest<Shipper, ShipperDto, ShipperMapper> (Shipper.class, ShipperDto.class, ShipperMapper.class);
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
