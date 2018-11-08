package com.julian.deliverp.api.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.julian.deliverp.api.mapper.GenericMapper;

public final class MapperTestGlobal<S, D> {
	
	
	private D craeteObject (Class<D> clas) throws InstantiationException, IllegalAccessException {
		return clas.newInstance();
	}

	void testNull(GenericMapper<S, D> mapper) {

		// given
		S source = null;
		D dto = null;

		// when
		D dtoFromSource = mapper.sourceToDto(source);
		S sourceFromDto = mapper.dtoToNewSource(dto);
		S sourceFromDtoAndSource = mapper.dtoToUpdatedSource(sourceFromDto, dto);

		// then
		assertNull(dtoFromSource);
		assertNull(sourceFromDto);
		assertNull(sourceFromDtoAndSource);
	}

	void testEmpty(GenericMapper<S, D> mapper, Class<D> dtoClass) throws InstantiationException, IllegalAccessException {

		// given
		D dto = craeteObject(dtoClass);

		// when
		S addressFromDto = mapper.dtoToNewSource(dto);

		// then
		assertNotNull(addressFromDto);
	}

}
