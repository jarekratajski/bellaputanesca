package com.julian.bella.api.mapper;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import com.julian.bella.api.dto.CallCenterConsultantDto;
import com.julian.bella.api.mapper.CallCenterConsultantMapper;
import com.julian.bella.domain.CallCenterConsultant;

public class CallCenterConsultantMapperTest {

EmployeeMapperTest<CallCenterConsultant, CallCenterConsultantDto, CallCenterConsultantMapper> emplTest;
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.emplTest = new EmployeeMapperTest<CallCenterConsultant, CallCenterConsultantDto, CallCenterConsultantMapper> (CallCenterConsultant.class, CallCenterConsultantDto.class, CallCenterConsultantMapper.class);
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
