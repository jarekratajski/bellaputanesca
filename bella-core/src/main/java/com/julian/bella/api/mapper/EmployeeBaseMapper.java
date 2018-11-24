package com.julian.bella.api.mapper;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.EmployeeDto;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.domain.Employee;
import com.julian.bella.domain.User;

@Component
public class EmployeeBaseMapper<S extends Employee, D extends EmployeeDto> implements GenericMapper<S, D> {

	UserMapper userMapper;
	Class<S> sourceClass;
	Class<D> dtoClass;

	@Autowired
	public EmployeeBaseMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public D sourceToDto(S source) {
		if (source == null) {
			return null;
		}
		UserDto userDto = userMapper.sourceToDto(source.getUser());

		D dto = null;
		try {
			dto = dtoClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setActive(source.isActive())
			.setPesel(source.peselEncrypted)
			.setFirstName(source.getFirstName())
			.setLastName(source.getLastName())
			.setUserDto(userDto);
		return dto;
	}
	
	@Override
	public S dtoToNewSource(D dto) {
		if(dto == null) {
			return null;
		}
		User user = userMapper.dtoToNewSource(dto.getUserDto());
		
		S source = null;
		try {
			source = sourceClass.getDeclaredConstructor(String.class).newInstance(dto.getPesel());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source.setActive(dto.isActive());
		source.setFirstName(dto.getFirstName());
		source.setLastName(dto.getLastName());
		source.setUser(user);
		return source;
	}
	
	@Override
	public S dtoToUpdatedSource(S source, D dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		User user = userMapper.dtoToUpdatedSource(source.getUser(), dto.getUserDto());
		
		source.setActive(dto.isActive());
		source.setFirstName(dto.getFirstName());
		source.setLastName(dto.getLastName());
		source.setUser(user);
		return source;
	}

	public void setSourceClassType(Class<S> sourceClassType) {
		this.sourceClass = sourceClassType;
	}

	public void setDtoClassType(Class<D> dtoClassType) {
		this.dtoClass = dtoClassType;
	}
}