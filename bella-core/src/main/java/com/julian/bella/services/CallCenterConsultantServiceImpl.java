package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.CallCenterConsultantDto;
import com.julian.bella.api.dto.CallCenterConsultantListDto;
import com.julian.bella.api.mapper.CallCenterConsultantMapper;
import com.julian.bella.domain.CallCenterConsultant;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.CallCenterConsultantRepo;

@Service
public class CallCenterConsultantServiceImpl implements CallCenterConsultantService {

	CallCenterConsultantRepo cccRepo;
	CallCenterConsultantMapper cccMapper;
	UserService userService;

	@Autowired
	public CallCenterConsultantServiceImpl(CallCenterConsultantRepo repo, CallCenterConsultantMapper mapper,
			UserService userService) {
		this.cccRepo = repo;
		this.cccMapper = mapper;
		this.userService = userService;
	}

	@Override
	public CallCenterConsultantListDto getAllCallCenterConsultants() {
		return new CallCenterConsultantListDto(
				cccRepo.findAll().stream().map(cccMapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public CallCenterConsultantDto getCallCenterConsultant(Long id) {
		return (CallCenterConsultantDto) cccMapper.sourceToDto(cccRepo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public CallCenterConsultantDto saveCallCenterConsultant(CallCenterConsultant ccc) {
		ccc = cccRepo.save(ccc);
		return (CallCenterConsultantDto) cccMapper.sourceToDto(ccc);
	}

	@Override
	public CallCenterConsultantDto createNewCallCenterConsultant(CallCenterConsultantDto cccDto) {
		cccDto.setUserDto(userService.getUserByLogin(cccDto.getUserDto().getLogin()));
		CallCenterConsultant ccc = (CallCenterConsultant) cccMapper.dtoToNewSource(cccDto);
		return this.saveCallCenterConsultant(ccc);
	}

	@Override
	public CallCenterConsultantDto updateCallCenterConsultant(Long id, CallCenterConsultantDto cccDto) {
		CallCenterConsultant oldCcc = cccRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		CallCenterConsultant newCcc = (CallCenterConsultant) cccMapper.dtoToUpdatedSource(oldCcc, cccDto);
		return this.saveCallCenterConsultant(newCcc);
	}

}
