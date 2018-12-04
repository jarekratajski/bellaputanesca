package com.julian.bella.initial;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.EmployeeDto;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.api.mapper.DriverMapper;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.domain.Address;
import com.julian.bella.domain.Client;
import com.julian.bella.domain.Driver;
import com.julian.bella.domain.Employee;
import com.julian.bella.domain.Location;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.OrderStatus;
import com.julian.bella.domain.Parcel;
import com.julian.bella.domain.ParcelType;
import com.julian.bella.domain.Route;
import com.julian.bella.domain.Shipper;
import com.julian.bella.domain.User;
import com.julian.bella.domain.Vehicle;
import com.julian.bella.repositories.AddressRepo;
import com.julian.bella.repositories.ClientRepo;
import com.julian.bella.repositories.DriverRepo;
import com.julian.bella.repositories.LocationRepo;
import com.julian.bella.repositories.OrderFinancesRepo;
import com.julian.bella.repositories.OrderRepo;
import com.julian.bella.repositories.ParcelRepo;
import com.julian.bella.repositories.RouteRepo;
import com.julian.bella.repositories.ShipperRepo;
import com.julian.bella.repositories.UserRepo;
import com.julian.bella.repositories.VehicleRepo;
import com.julian.bella.rodo.UserRole;
import com.julian.bella.services.DriverService;
import com.julian.bella.services.VehicleService;

@Component
public class InitialData implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	ClientRepo clientRepo;
	AddressRepo addressRepo;
	OrderRepo orderRepo;
	OrderFinancesRepo orderFinancesRepo;
	ParcelRepo parcelRepo;

	LocationRepo locationRepo;
	VehicleRepo vehicleRepo;
	DriverRepo driverRepo;
	ShipperRepo shipperRepo;
	RouteRepo routeRepo;

	UserRepo userRepo;
	
	DriverService driverService;
	
	@Autowired
	VehicleService vehicleService;

	@Autowired
	public InitialData(ClientRepo clientRepo, AddressRepo addressRepo, OrderRepo orderRepo,
			OrderFinancesRepo orderFinancesRepo, ParcelRepo parcelRepo, LocationRepo locationRepo,
			VehicleRepo vehicleRepo, DriverRepo driverRepo, ShipperRepo shipperRepo, RouteRepo routeRepo,
			UserRepo userRepo, DriverService driverService) {

		this.clientRepo = clientRepo;
		this.addressRepo = addressRepo;
		this.orderRepo = orderRepo;
		this.orderFinancesRepo = orderFinancesRepo;
		this.parcelRepo = parcelRepo;

		this.locationRepo = locationRepo;
		this.vehicleRepo = vehicleRepo;
		this.driverRepo = driverRepo;
		this.shipperRepo = shipperRepo;
		this.routeRepo = routeRepo;

		this.userRepo = userRepo;
		
		this.driverService = driverService;
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
		//debugVehicle2();
		//debugDriver();
		debugVehicle();
	}

	public void initData() {
		log.trace("Data initialization started...");

		// users --------------------------------------------------------
		User user0 = new User().setEmail("examle@example.com").setLogin("user").setUserRole(UserRole.CLIENT);
		userRepo.save(user0);

		User user1 = new User().setEmail("examle1@example.com").setLogin("user1").setUserRole(UserRole.CLIENT);
		userRepo.save(user1);

		User user2 = new User().setEmail("driver@example.com").setLogin("user2").setUserRole(UserRole.DRIVER);
		userRepo.save(user2);

		// address
		Address address0 = new Address("Wrocław", "Grabiszyńska", "31/6", "50-550");
		addressRepo.save(address0);
		Address address1 = new Address("Wrocław", "Plac Orląt Lwowskich", "1", "52-530");
		addressRepo.save(address1);
		Address address2 = new Address("Warszawa", "Obozowa", "1/1", "01-418");
		addressRepo.save(address2);
		Address address3 = new Address("Warszawa", "Kasprzaka", "1/1", "01-225");
		addressRepo.save(address3);

		// clients --------------------------------------------------------
		Client client0 = new Client("3422742010");
		client0.setCompanyName("Restart sp. z o.o.");
		client0.setUser(user0);
		client0.setContactAddress(address0);
		client0.setRegisterAddress(address1);
		clientRepo.save(client0);

		Client client00 = new Client("9510525054");
		client00.setCompanyName("Janusz Soft sp. z o.o.");
		client00.setUser(user1);
		clientRepo.save(client00);

		Client client1 = new Client("1076720020");
		client1.setCompanyName("Warzywniak s.c.");
		clientRepo.save(client1);

		// orders --------------------------------------------------------
		Order order0 = new Order();
		order0.setNotes("zero-note");
		order0.addClient(client0);
		order0.addClient(client00);
		orderRepo.save(order0);

		Order order1a = new Order();
		order1a.setNotes("one-a-note");
		order1a.addClient(client1);
		orderRepo.save(order1a);
		clientRepo.save(client1);

		Order order1b = new Order();
		order1b.setNotes("one-b-note");
		order1b.addClient(client1);
		orderRepo.save(order1b);
		clientRepo.save(client1);

		// finances of orders --------------------------------------------------------
		order0.getFinances().setFinalExpense(new BigDecimal(20));
		order0.getFinances().setFinalPrice(new BigDecimal(110));
		orderFinancesRepo.save(order0.getFinances());

		order1a.getFinances().setFinalExpense(new BigDecimal(200));
		order1a.getFinances().setFinalPrice(new BigDecimal(210));
		orderFinancesRepo.save(order1a.getFinances());

		order1b.getFinances().setFinalExpense(new BigDecimal(10));
		order1b.getFinances().setFinalPrice(new BigDecimal(310));
		orderFinancesRepo.save(order1b.getFinances());

		order0.updateStatus(OrderStatus.SUCCESSFULLY_FINISHED);
		orderRepo.save(order0);
		clientRepo.save(client0);
		clientRepo.save(client00);

		// parcels --------------------------------------------------------
		Parcel parcel0 = new Parcel(ParcelType.LETTER, 0.01, 1, false, order0);
		parcel0.setDescription(
				"The parcel contains medical drugs. It must be convey in cold temperature under 25 degrees.");
		parcelRepo.save(parcel0);

		Parcel parcel00 = new Parcel(ParcelType.LETTER, 0.01, 1, false, order0);
		parcelRepo.save(parcel00);

		Parcel parcel1 = new Parcel(ParcelType.DEFAULT, 0.01, 1, true, order1a);
		parcelRepo.save(parcel1);

		Parcel parcel2 = new Parcel(ParcelType.DEFAULT, 0.01, 1, true, order1b);
		parcelRepo.save(parcel2);

		// locations --------------------------------------------------------
		Location location0 = new Location(address2, 20.9390417, 52.2464565);
		locationRepo.save(location0);

		Location location00 = new Location(address3, 20.6390417, 52.0464565);
		locationRepo.save(location00);

		// employees --------------------------------------------------------
		Driver employee0 = new Driver("94112757255", "Janusz", "Nosacz", true);
		employee0.setUser(user2);
		driverRepo.save(employee0);
		Shipper employee1 = new Shipper("92022851144", "Grażyna", "Kowalska", true);
		shipperRepo.save(employee1);

		// vehicles --------------------------------------------------------
		Vehicle vehicle0 = new Vehicle("1FTEF27L2VND02190");
		vehicle0.setCapacity(1500);
		vehicle0.setPurchaseDate(LocalDate.of(2016, 01, 17));
		vehicle0.setDriver(employee0);
		vehicle0.incrementMileage(144);
		vehicleRepo.save(vehicle0);

		// routes --------------------------------------------------------
		Route route0 = new Route(order0, location0, location00);
		route0.setVehicle(vehicle0);
		routeRepo.save(route0);
		orderRepo.save(order0);

		Route route1 = new Route(order1a, location0, location00);
		route1.setVehicle(vehicle0);
		routeRepo.save(route1);
		orderRepo.save(order1a);

		Route route2 = new Route(order1b, location0, location00);
		routeRepo.save(route2);
		orderRepo.save(order1b);

		log.info("Succesfully finished initializing data.");
	}

	public void debugVehicle2() {
		System.out.println(" ****************** W * A * T * ? ****************** ");
		User user2 = new User().setEmail("driver@example.com").setLogin("user2").setUserRole(UserRole.DRIVER);
		
		Employee employee0 = new Driver("94112757255", "Janusz", "Nosacz", true);
		employee0.setUser(user2);
		
		boolean isInstanceOfEmployee = employee0 instanceof Employee;
		System.out.println("is instance of Employee: " + isInstanceOfEmployee);
		System.out.println("is Driver assignable from Employee: " + Driver.class.isAssignableFrom(employee0.getClass()));
		
		
		Vehicle vehicle0 = new Vehicle("1FTEF27L2VND02190");
		vehicle0.setCapacity(1500);
		vehicle0.setPurchaseDate(LocalDate.of(2016, 01, 17));
		vehicle0.setDriver((Driver) employee0);
		vehicle0.incrementMileage(144);
		
		UserMapper userMapper = new UserMapper();
		DriverMapper driverMapper = new DriverMapper(userMapper);

		EmployeeDto e = driverMapper.sourceToDto(vehicle0.getDriver());
		
		boolean isInstanceOfEmployeeDto = e instanceof EmployeeDto;
		System.out.println("is instance of EmployeeDto: " + isInstanceOfEmployeeDto);
		System.out.println("is DriverDto assignable from EmployeeDto: " + DriverDto.class.isAssignableFrom(e.getClass()));
		System.out.println(" *********************** ");
		
		DriverDto drvDto = (DriverDto) e;
		System.out.println(drvDto.getFirstName());
	}
	
	public void debugDriver() {
		UserDto userrr = new UserDto();
		userrr.setEmail("email@wp.com").setLogin("cc");
		
		DriverDto dto = new DriverDto();
		dto.setActive(true).setFirstName("aa").setLastName("bb").setPesel("90011816297").setUserDto(userrr);
		
		driverService.createNewDriver(dto);
	}
	
	public void debugVehicle() {
		UserDto userDto = new UserDto();
		userDto.setEmail("aaaa@aa.com").setLogin("user1");
		
		DriverDto drvDto = new DriverDto();
		drvDto.setActive(false).setFirstName("aa").setLastName("bb").setPesel("90011816297").setId(2L)
				.setUserDto(userDto);
		
		driverService.createNewDriver(drvDto);
		
		VehicleDto v = new VehicleDto();
		v.setCapacityKg(0).setMileageKm(0).setPurchaseDate(LocalDate.now()).setVin("1GCPKSE72CF207050")
		.setDriverDto(drvDto);
		vehicleService.createNewVehicle(v);
		
	}

}
