package com.julian.deliverp.services;

import org.springframework.stereotype.Service;

import com.julian.deliverp.api.dto.ClientDto;
import com.julian.deliverp.api.dto.ClientListDto;
import com.julian.deliverp.domain.Client;

@Service
public interface ClientService {

	ClientListDto getAllClients();
	
	ClientDto getClient(String nip);

	ClientDto getClient(Long id);
	
	ClientDto saveClient(Client client);
	
	ClientDto createNewClient(ClientDto clientDto);
	
	ClientDto updateClient(Long id, ClientDto clientDto);
	
	ClientDto updateClient(String nip, ClientDto clientDto);
	
	void deleteClientById(Long id);
	
	void deleteClientByNip(String nip);
	
}
