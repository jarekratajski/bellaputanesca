package com.julian.bella.services;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.RouteDto;
import com.julian.bella.api.dto.RouteListDto;
import com.julian.bella.api.mapper.RouteMapper;
import com.julian.bella.domain.Route;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.RouteRepo;

@Service
public class RouteServiceImpl implements RouteService {

	RouteRepo repo;
	RouteMapper mapper;
	
	public RouteServiceImpl(RouteRepo repo, RouteMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public RouteListDto getAllRoutes() {
		return new RouteListDto(repo.findAll().stream().map(mapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	@Transactional
	public RouteDto getRoute(Long id) {
		return mapper.sourceToDto(repo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public RouteDto saveRoute(Route route) {
		route = repo.save(route);
		return mapper.sourceToDto(route);
	}

	@Override
	public RouteDto createNewRoute(RouteDto dto) {
		Route r = mapper.dtoToNewSource(dto);
		return this.saveRoute(r);
	}

	@Override
	public RouteDto updateRoute(Long id, RouteDto dto) {
		Route oldRoute = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
		Route newRoute = mapper.dtoToUpdatedSource(oldRoute, dto);
		return this.saveRoute(newRoute);
	}

	@Override
	public void deleteRouteById(Long id) {
		repo.deleteById(id);
	}

}
