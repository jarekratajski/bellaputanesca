package com.julian.deliverp.api.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.deliverp.api.dto.AddressDto;
import com.julian.deliverp.api.dto.ClientDto;
import com.julian.deliverp.api.dto.UserDto;
import com.julian.deliverp.domain.Address;
import com.julian.deliverp.domain.Client;
import com.julian.deliverp.domain.User;

@Component
public class ClientMapper implements GenericMapper<Client, ClientDto> {

	private GenericMapper<Address, AddressDto> addressMapper;
	private GenericMapper<User, UserDto> userMapper;
	
	@Autowired
	public ClientMapper(GenericMapper<Address, AddressDto> addressMapper, GenericMapper<User, UserDto> userMapper) {
		this.addressMapper = addressMapper;
		this.userMapper = userMapper;
	}
	
	@Override
	public ClientDto sourceToDto(Client client) {
		if(client == null) {
			return null;
		}
		AddressDto contactAddressDto = addressMapper.sourceToDto(client.getContactAddress());
		AddressDto registerAddressDto = addressMapper.sourceToDto(client.getRegisterAddress());
		UserDto userDto = userMapper.sourceToDto(Optional.ofNullable(client.getUser()).orElse(new User()));

		
		ClientDto clientDto = new ClientDto();
		clientDto.setId(client.getId())
			.setUser(userDto)
			.setNip(client.getNip())
			.setCompanyName(client.getCompanyName())
			.setContactAddress(contactAddressDto)
			.setRegisterAddress(registerAddressDto);
		
		return clientDto;
	}

	@Override
	public Client dtoToNewSource(ClientDto clientDto) {
		if(clientDto == null) {
			return null;
		}
		Address contactAddress = addressMapper.dtoToNewSource(clientDto.getContactAddress());
		Address registerAddress = addressMapper.dtoToNewSource(clientDto.getRegisterAddress());
		User userDto = Optional.ofNullable(userMapper.dtoToNewSource(clientDto.getUser())).orElse(new User());
		
		Client client = new Client(clientDto.getNip());
		client.setCompanyName(clientDto.getCompanyName());
		client.setContactAddress(contactAddress);
		client.setRegisterAddress(registerAddress);
		client.setUser(userDto);
		
		return client;
	}
	
	@Override
	public Client dtoToUpdatedSource(Client client, ClientDto clientDto) {
		if(clientDto == null) {
			return null;
		}
		if(client == null) {
			return dtoToNewSource(clientDto);
		}
		Address contactAddress = addressMapper.dtoToUpdatedSource(client.getContactAddress(), clientDto.getContactAddress());
		Address registerAddress = addressMapper.dtoToUpdatedSource(client.getRegisterAddress(), clientDto.getRegisterAddress());
		User user = Optional.ofNullable(userMapper.dtoToUpdatedSource(client.getUser(), clientDto.getUser())).orElse(new User());
		
		client.setCompanyName(clientDto.getCompanyName());
		client.setUser(user);
		client.setContactAddress(contactAddress);
		client.setRegisterAddress(registerAddress);
		
		return client;
	}

}
