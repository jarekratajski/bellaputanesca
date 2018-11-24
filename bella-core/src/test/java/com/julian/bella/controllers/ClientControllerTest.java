package com.julian.bella.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.julian.bella.api.dto.AddressDto;
import com.julian.bella.api.dto.ClientDto;
import com.julian.bella.api.dto.ClientListDto;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.controllers.ClientController;
import com.julian.bella.services.ClientService;

public class ClientControllerTest {

	@Mock
	ClientService clientService;

	@InjectMocks
	ClientController clientController;

	MockMvc mockMvc;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}

	public UserDto getSampleUserDto() {
		UserDto dto = new UserDto();
		dto.setLogin(dto.getLogin());
		return dto;
	}

	public AddressDto getSampleAddressDto() {
		AddressDto dto = new AddressDto();
		dto.setCity("city").setHouseNumberEtc("houseNumberEtc").setPostalCode("postalCode").setStreet("street");
		return dto;
	}

	public ClientDto getSampleClientDto() {
		return getSampleClientDto("9492109373", 0L, "KONSULTANT ANALIZY DANYCH WOJCIECH OBŁĄK", "wojciech.oblak");
	}

	public ClientDto getSampleClientDto(String nip, Long id, String name, String login) {
		UserDto user = getSampleUserDto();
		AddressDto address = getSampleAddressDto();
		ClientDto client = new ClientDto();
		client.setNip(nip).setCompanyName(name).setUser(user).setContactAddress(address).setRegisterAddress(address);
		return client;
	}

	@Test
	public void testGetAllClients() throws Exception {

		// given
		ClientDto client = getSampleClientDto();
		ClientDto client1 = getSampleClientDto("9281996590", 1L, "Produkcja gier i zabawek Inf", "Janusz Nosacz");
		ClientListDto clients = new ClientListDto(Arrays.asList(client, client1));

		// when
		when(clientService.getAllClients()).thenReturn(clients);

		// then
		mockMvc.perform(get("/api/clients")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
				.andExpect(jsonPath("$.clients", hasSize(2)));
	}

	@Test
	public void testGetClient() throws Exception {

		// given
		ClientDto clientDto = getSampleClientDto();

		// when
		when(clientService.getClient(anyString())).thenReturn(clientDto);

		// then
		mockMvc.perform(get("/api/clients/nip=9492109373")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nip", equalTo("9492109373")));
	}

	@Test
	public void testCreateNewClient() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setLogin("testlogin");

		AddressDto addressDto = new AddressDto();
		addressDto.setCity("testcity").setHouseNumberEtc("1").setStreet("teststreet").setPostalCode("00-001");

		ClientDto dto = new ClientDto();
		dto.setCompanyName("testName").setNip("7740001454").setUser(userDto).setRegisterAddress(addressDto);

		when(clientService.saveClient(any())).thenReturn(dto);

		mockMvc.perform(
				post("api/clients")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("nip", "7740001454")
				).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/api/clients/nip=7740001454"));

	}

	@Test
	public void testUpdateClient() throws Exception {

		// given
		ClientDto clientDto = getSampleClientDto();

		// when
		when(clientService.updateClient("9492109373", clientDto)).thenReturn(clientDto);

		// then
		mockMvc.perform(post("/api/clients")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.clients", hasSize(1)));
	}

	@Test
	public void testDeleteClient() throws Exception {

		// given
		ClientDto clientDto = getSampleClientDto();

		// when
		when(clientService.updateClient("9492109373", clientDto)).thenReturn(clientDto);

		// then
		mockMvc.perform(post("/api/clients")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.clients", hasSize(1)));
	}

}
