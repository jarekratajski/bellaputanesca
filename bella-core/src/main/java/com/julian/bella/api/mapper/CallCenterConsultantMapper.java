package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.CallCenterConsultantDto;
import com.julian.bella.domain.CallCenterConsultant;

@Component
public class CallCenterConsultantMapper implements GenericMapper<CallCenterConsultant, CallCenterConsultantDto>{
	EmployeeBaseMapper<CallCenterConsultant, CallCenterConsultantDto> baseMapper;
	
	@Autowired
	public CallCenterConsultantMapper(EmployeeBaseMapper<CallCenterConsultant, CallCenterConsultantDto> baseMapper) {
		this.baseMapper = baseMapper;
		baseMapper.setSourceClassType(CallCenterConsultant.class);
		baseMapper.setDtoClassType(CallCenterConsultantDto.class);
	}
	
	@Override
	public CallCenterConsultantDto sourceToDto(CallCenterConsultant source) {		
		return baseMapper.sourceToDto(source);
	}

	@Override
	public CallCenterConsultant dtoToNewSource(CallCenterConsultantDto dto) {
		return baseMapper.dtoToNewSource(dto);
	}

	@Override
	public CallCenterConsultant dtoToUpdatedSource(CallCenterConsultant source, CallCenterConsultantDto dto) {
		return baseMapper.dtoToUpdatedSource(source, dto);
	}
}