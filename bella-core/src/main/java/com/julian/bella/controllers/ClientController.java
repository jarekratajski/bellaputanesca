package com.julian.bella.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.julian.bella.api.dto.ClientDto;
import com.julian.bella.api.dto.ClientListDto;
import com.julian.bella.services.ClientService;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService service) {
		this.clientService = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ClientListDto getAllClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping("/nip={nip}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientDto getClient(@PathVariable String nip) {
		return clientService.getClient(nip);
	}
	
	@GetMapping("orderId={orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientListDto getAllClientsForOrder(Long orderId) {
		return clientService.getAllClientsForOrder(orderId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientDto createNewClient(@RequestBody ClientDto clientDto) {
		return clientService.createNewClient(clientDto);
	}
	
	@PutMapping("/nip={nip}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientDto updateClient(@PathVariable String nip, @RequestBody ClientDto clientDto) {
		return clientService.updateClient(nip, clientDto);
	}
	
	@DeleteMapping("/nip={nip}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteClient(@PathVariable String nip) {
		clientService.deleteClientByNip(nip);
	}	
}
