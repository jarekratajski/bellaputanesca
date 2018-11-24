package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ClientDto;
import com.julian.bella.api.dto.ClientListDto;
import com.julian.bella.domain.Client;

@Service
public interface ClientService {

	ClientListDto getAllClients();
	
	ClientDto getClient(String nip);
	
	ClientListDto getAllClientsForOrder(Long id);

	ClientDto getClient(Long id);
	
	ClientDto saveClient(Client client);
	
	ClientDto createNewClient(ClientDto clientDto);
	
	ClientDto updateClient(String nip, ClientDto clientDto);
	
	void deleteClientByNip(String nip);
	
}
