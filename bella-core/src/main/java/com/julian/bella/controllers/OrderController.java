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

import com.julian.bella.api.dto.OrderDto;
import com.julian.bella.api.dto.OrderFinancesDto;
import com.julian.bella.api.dto.OrderListDto;
import com.julian.bella.api.dto.OrderStatusHistoryListDto;
import com.julian.bella.services.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService service;
	
	@Autowired
	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public OrderListDto getAllOrders() {
		return service.getAllOrders();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderDto getOrder(@PathVariable Long id) {
		return service.getOrder(id);
	}
	
	@GetMapping("/nip={nip}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderListDto getAllOrdersForClient(@PathVariable String nip) {
		return service.getAllOrdersForClient(nip);
	}
	
	@GetMapping("/status/orderId={orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderStatusHistoryListDto getStatusHistory(@PathVariable Long orderId) {
		return service.getStatusHistory(orderId);
	}
	
	@GetMapping("/finances/orderId={orderId}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderFinancesDto getFinances(@PathVariable Long orderId) {
		return service.getFinances(orderId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderDto createNewOrder(@RequestBody OrderDto orderDto) {
		return null;
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderDto updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		return null;
	}
	
	@DeleteMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteOrder(@PathVariable Long id) {

	}	
}
