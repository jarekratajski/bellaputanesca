package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.CallCenterConsultantDto;
import com.julian.bella.api.dto.CallCenterConsultantListDto;
import com.julian.bella.domain.CallCenterConsultant;

@Service
public interface CallCenterConsultantService {
	
	CallCenterConsultantListDto getAllCallCenterConsultants();

	CallCenterConsultantDto getCallCenterConsultant(Long id);

	CallCenterConsultantDto saveCallCenterConsultant(CallCenterConsultant cCConsultant);

	CallCenterConsultantDto createNewCallCenterConsultant(CallCenterConsultantDto cccDto);

	CallCenterConsultantDto updateCallCenterConsultant(Long id, CallCenterConsultantDto cccDto);

}
