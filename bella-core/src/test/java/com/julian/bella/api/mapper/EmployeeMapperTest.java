package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import com.julian.bella.api.dto.EmployeeDto;
import com.julian.bella.api.mapper.EmployeeBaseMapper;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.domain.Employee;
import com.julian.bella.rodo.HashMD5;

public class EmployeeMapperTest<S extends Employee, D extends EmployeeDto, M extends GenericMapper<S, D>> {

	GenericMapper<S, D> mapper;
	Class<S> sourceClass;
	Class<D> dtoClass;
	Class<M> mapperClass;

	final String DEFAULT_NAME = "testname";
	final String DEFAULT_NAME2 = "testname2";
	final String DEFAULT_LAST_NAME = "testlastname";
	final String DEFAULT_LAST_NAME2 = "testlastname2";
	final String DEFAULT_PESEL = "92071314764";

	public EmployeeMapperTest(Class<S> sourceClassType, Class<D> dtoClassType, Class<M> mapperClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.sourceClass = sourceClassType;
		this.dtoClass = dtoClassType;
		this.mapperClass = mapperClass;
		UserMapper userMapper = new UserMapper();
	    EmployeeBaseMapper<S, D> baseMapper = new EmployeeBaseMapper<>(userMapper);
	    this.mapper = mapperClass.getConstructor(EmployeeBaseMapper.class).newInstance(baseMapper);
	}

	public D getDefaultDto() throws InstantiationException, IllegalAccessException {
		D dto = dtoClass.newInstance();
		dto.setFirstName(DEFAULT_NAME).setLastName(DEFAULT_LAST_NAME).setPesel(DEFAULT_PESEL).setActive(true);
		return dto;
	}

	public S getDefaultSource() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		S s = sourceClass.getConstructor(String.class, String.class, String.class, Boolean.TYPE)
				.newInstance(DEFAULT_PESEL, DEFAULT_NAME2, DEFAULT_LAST_NAME2, true);
		return s;
	}

	public void testNullAndEmpty() {
		MapperTestGlobal<S, D> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
	}

	public void testSourceToDto() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// given
		S source = getDefaultSource();

		// when
		D dto = mapper.sourceToDto(source);

		// then
		assertEquals(DEFAULT_NAME2, dto.getFirstName());
		assertEquals(DEFAULT_LAST_NAME2, dto.getLastName());
		assertTrue(dto.isActive());
	}

	public void testDtoToNewSource() throws InstantiationException, IllegalAccessException {
		// given
		D dto = getDefaultDto();

		// when
		S source = mapper.dtoToNewSource(dto);

		// then
		assertNotNull(source.peselEncrypted);
		assertEquals(HashMD5.getHashed(DEFAULT_PESEL), source.peselEncrypted);
		assertEquals(DEFAULT_NAME, source.getFirstName());
		assertEquals(DEFAULT_LAST_NAME, source.getLastName());
		assertTrue(source.isActive());
	}

	public void testDtoUpdateFromSource() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// given
		S source = getDefaultSource();
		source.setActive(false);
		D dto = getDefaultDto();

		// when
		S newSource = mapper.dtoToUpdatedSource(source, dto);

		// then
		assertNotNull(newSource.peselEncrypted);
		assertEquals(HashMD5.getHashed(DEFAULT_PESEL), newSource.peselEncrypted);
		assertEquals(DEFAULT_NAME, newSource.getFirstName());
		assertEquals(DEFAULT_LAST_NAME, newSource.getLastName());
		assertTrue(newSource.isActive());
	}
}
