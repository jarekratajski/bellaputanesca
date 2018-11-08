package com.julian.deliverp.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.julian.deliverp.api.dto.ClientDto;
import com.julian.deliverp.api.dto.ClientListDto;
import com.julian.deliverp.api.mapper.GenericMapper;
import com.julian.deliverp.domain.Client;
import com.julian.deliverp.repositories.AddressRepo;
import com.julian.deliverp.repositories.ClientRepo;
import com.julian.deliverp.repositories.UserRepo;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepo clientRepo;
	private UserRepo userRepo;
	private AddressRepo addressRepo;
	private GenericMapper<Client, ClientDto> clientMapper;
	
	public ClientServiceImpl(ClientRepo repo, AddressRepo addressRepo, UserRepo userRepo, GenericMapper<Client, ClientDto> mapper) {
		this.clientRepo = repo;
		this.userRepo = userRepo;
		this.addressRepo = addressRepo;
		this.clientMapper = mapper;
	}
	
	@Override
	public ClientListDto getAllClients() {
		return new ClientListDto(
				clientRepo.findAll().stream().map(clientMapper::sourceToDto).collect(Collectors.toList())
				);
	}

	@Override
	public ClientDto getClient(String nip) {
		return clientMapper.sourceToDto(clientRepo.findByNip(nip).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public ClientDto getClient(Long id) {
		return clientMapper.sourceToDto(clientRepo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public ClientDto createNewClient(ClientDto clientDto) {
		Client client = clientMapper.dtoToNewSource(clientDto);
		userRepo.save(client.getUser());
		addressRepo.save(client.getContactAddress());
		addressRepo.save(client.getRegisterAddress());
		clientRepo.save(client);
		return clientDto;
	}
	
	@Override
	public ClientDto saveClient(Client client) {
		userRepo.save(client.getUser());
		addressRepo.save(client.getContactAddress());
		addressRepo.save(client.getRegisterAddress());
		clientRepo.save(client);
		return clientMapper.sourceToDto(client);
	}

	@Override
	public ClientDto updateClient(Long id, ClientDto clientDto) {
		Client oldClient = clientRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		Client newClient = clientMapper.dtoToUpdatedSource(oldClient, clientDto);
		return saveClient(newClient);
	}

	@Override
	public ClientDto updateClient(String nip, ClientDto clientDto) {
		Client oldClient = clientRepo.findByNip(nip).orElseThrow(ResourceNotFoundException::new);
		Client newClient = clientMapper.dtoToUpdatedSource(oldClient, clientDto);
		return saveClient(newClient);
	}

	@Override
	public void deleteClientById(Long id) {
		clientRepo.deleteById(id);
	}

	@Override
	public void deleteClientByNip(String nip) {
		clientRepo.deleteByNip(nip);
	}
}
