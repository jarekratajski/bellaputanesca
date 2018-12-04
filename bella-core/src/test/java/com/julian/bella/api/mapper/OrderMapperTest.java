package com.julian.bella.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.julian.bella.api.dto.OrderDto;
import com.julian.bella.api.dto.OrderFinancesDto;
import com.julian.bella.api.dto.OrderStatusHistoryDto;
import com.julian.bella.api.dto.OrderStatusHistoryListDto;
import com.julian.bella.api.mapper.AddressMapper;
import com.julian.bella.api.mapper.ClientMapper;
import com.julian.bella.api.mapper.GenericMapper;
import com.julian.bella.api.mapper.LocationMapper;
import com.julian.bella.api.mapper.OrderFinancesMapper;
import com.julian.bella.api.mapper.OrderMapper;
import com.julian.bella.api.mapper.OrderStatusHistoryMapper;
import com.julian.bella.api.mapper.ParcelMapper;
import com.julian.bella.api.mapper.RouteMapper;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.api.mapper.VehicleMapper;
import com.julian.bella.domain.Address;
import com.julian.bella.domain.Client;
import com.julian.bella.domain.Driver;
import com.julian.bella.domain.Location;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.OrderFinances;
import com.julian.bella.domain.OrderStatus;
import com.julian.bella.domain.Parcel;
import com.julian.bella.domain.ParcelType;
import com.julian.bella.domain.Route;
import com.julian.bella.domain.Vehicle;

public class OrderMapperTest {

	GenericMapper<Order, OrderDto> mapper;
	GenericMapper<OrderFinances, OrderFinancesDto> financesMapper;
	final String DEFAULT_NIP = "9492109373";
	final String DEFAULT_VIN = "3GNAL2EK7ES630526";
	
	@Before
	public void setUp() {
		AddressMapper addressMapper = new AddressMapper();
		UserMapper userMapper = new UserMapper();
		ClientMapper clientMapper = new ClientMapper(addressMapper, userMapper);
		ParcelMapper parcelMapper = new ParcelMapper();
		LocationMapper locationMapper = new LocationMapper(addressMapper);
		VehicleMapper vehicleMapper = new VehicleMapper();
		RouteMapper routeMapper = new RouteMapper(locationMapper, vehicleMapper, null);		
		OrderStatusHistoryMapper statusMapper = new OrderStatusHistoryMapper();
		this.mapper = new OrderMapper(clientMapper, parcelMapper, routeMapper, statusMapper);
		this.financesMapper = new OrderFinancesMapper();
	}
	
	@Test 
	public void testNullAndEmpty() throws InstantiationException, IllegalAccessException {
		MapperTestGlobal<Order, OrderDto> mtg = new MapperTestGlobal<>();
		mtg.testNull(mapper);
		mtg.testEmpty(mapper, OrderDto.class);
	}
	
	@Test
	public void testSourceToDto() throws JsonProcessingException  {
		// given
		ObjectMapper jackson = new ObjectMapper();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		jackson.setDateFormat(df);
	    
		Driver driver = new Driver("12241883098");
		driver.setFirstName("Janusz");
		Vehicle vehicle = new Vehicle(DEFAULT_VIN);
		vehicle.setCapacity(1500);
		vehicle.setDriver(driver);
		Order order = new Order();
		order.setNotes("mynotes");
		Address address = new Address("city", "street", "housenumberetc", "00-001");
		Location from = new Location(address, 1, 2);
		Location to = new Location(address, 1, 2);
		Route route = new Route(order, from, to);
		route.setVehicle(vehicle);
		order.setRoute(route);
		
		Client client = new Client(DEFAULT_NIP);
		client.setCompanyName("name");
		client.setContactAddress(address);
		order.addClient(client);
		
		Parcel parcel = new Parcel(ParcelType.BOX_PACKAGE, 1, 2, true, order);
		order.addParcel(parcel);
		
		order.updateStatus(OrderStatus.CANCELLED);
		
		// when
		OrderDto dto = mapper.sourceToDto(order);
		
		Parcel p = null;
		Iterator<Parcel> itParcel = order.getParcelsCopy().iterator();
		if(itParcel.hasNext()) {
			p = itParcel.next();
		}
		
		Client c = null;
		Iterator<Client> itClient = order.getClientsCopy().iterator();
		if(itClient.hasNext()) {
			c = itClient.next();
		}
	
		// then
		assertEquals(OrderStatus.CANCELLED, dto.getActualStatus());
		assertEquals(2, order.getStatusHistoryCopy().size());
		assertEquals(OrderStatus.CREATED, order.getStatusHistoryCopy().get(0).status);
		assertEquals(OrderStatus.CANCELLED, order.getStatusHistoryCopy().get(1).status);
		assertNotNull(order.getStatusHistoryCopy().get(0).dateTime);
		assertEquals("street", order.getRoute().from.address.street);
		assertEquals(1500, order.getRoute().getVehicle().getCapacity(), 0);
		assertEquals("Janusz", order.getRoute().getVehicle().getDriver().getFirstName());
		assertEquals(1, order.getParcelsCopy().size());
		assertEquals(ParcelType.BOX_PACKAGE, p.type);
		assertEquals(1, order.getClientsCopy().size());
		assertEquals(DEFAULT_NIP, c.nip);
		assertEquals("00-001", c.getContactAddress().postalCode);
		assertEquals("mynotes", order.getNotes());
	}
	
	@Test
	public void testDtoToNewSource() {
		// given
		OrderDto dto = new OrderDto();
		dto.setActualStatus(OrderStatus.PAUSED).setNotes("notes");
		
		// when
		Order order = mapper.dtoToNewSource(dto);
		
		// then
		assertEquals(OrderStatus.PAUSED, order.getActualStatus());
		assertEquals("notes", order.getNotes());
		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), order.getFinances().getFinalPrice());
	}
	
	@Test
	public void testDtoToUpdatedSource() {
		// given
		OrderDto dto = new OrderDto();
		OrderStatusHistoryDto statusHistoryDto = new OrderStatusHistoryDto();
		statusHistoryDto.setDateTime(LocalDateTime.now()).setStatus(OrderStatus.DEFAULT);
		List<OrderStatusHistoryDto> statusHistoryDtoList = Arrays.asList(statusHistoryDto);
		OrderStatusHistoryListDto statusHistoryListDto = new OrderStatusHistoryListDto(statusHistoryDtoList);
		dto.setStatusHistory(statusHistoryListDto);
		dto.setActualStatus(OrderStatus.REJECTED_BY_SHIPPER);
		Order source = new Order();
		source.setNotes("aaa");
		
		// when
		Order order = mapper.dtoToUpdatedSource(source, dto);
		
		// then
		assertEquals(OrderStatus.REJECTED_BY_SHIPPER, order.getActualStatus());
		assertNull(order.getNotes());
		assertEquals(OrderStatus.DEFAULT, dto.getStatusHistory().getDtoList().get(0).getStatus());
		assertEquals(OrderStatus.CREATED, source.getStatusHistoryCopy().get(0).status);
		assertEquals(OrderStatus.REJECTED_BY_SHIPPER, source.getStatusHistoryCopy().get(1).status);
	}
}
