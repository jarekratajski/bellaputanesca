package com.julian.deliverp.api.dto;

import java.util.List;

public final class ClientListDto {

	private List<ClientDto> clients;

	public ClientListDto(List<ClientDto> list) {
		this.clients = list;
	}

	public List<ClientDto> getClients() {
		return clients;
	}

	public void setClients(List<ClientDto> clients) {
		this.clients = clients;
	}

}
