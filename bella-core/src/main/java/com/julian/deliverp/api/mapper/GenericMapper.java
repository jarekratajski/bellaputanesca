package com.julian.deliverp.api.mapper;

import org.springframework.stereotype.Component;

@Component
public interface GenericMapper<S, D> {

	D sourceToDto(S source);
	
	S dtoToNewSource(D dto);

	S dtoToUpdatedSource(S source, D dto);
}
