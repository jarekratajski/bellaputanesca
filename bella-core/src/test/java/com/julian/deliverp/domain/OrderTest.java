package com.julian.deliverp.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testOrder() {
		// given
		Order order = new Order();
		
		// when
		OrderStatus status = order.getActualStatus();
		List<OrderStatusHistory> statusHistoryList = order.getStatusHistoryCopy();
		
		// then
		assertEquals(OrderStatus.CREATED, status);
		assertEquals(1, statusHistoryList.size());
		assertEquals(OrderStatus.CREATED, statusHistoryList.get(0).status);
	}

	@Test
	public void testUpdateStatus() {
		// given
		Order order = new Order();
		
		// when
		order.updateStatus(OrderStatus.DRIVER_ASSIGNED);
		order.updateStatus(OrderStatus.SUCCESSFULLY_FINISHED);
		order.updateStatus(OrderStatus.REJECTED_BY_SHIPPER);
		
		List<OrderStatusHistory> statusHistoryList = order.getStatusHistoryCopy();
		
		// then
		assertEquals(OrderStatus.SUCCESSFULLY_FINISHED, order.getActualStatus());
		assertEquals(3, statusHistoryList.size());
		assertEquals(OrderStatus.CREATED, statusHistoryList.get(0).status);
		assertEquals(OrderStatus.DRIVER_ASSIGNED, statusHistoryList.get(1).status);
		assertEquals(OrderStatus.SUCCESSFULLY_FINISHED, statusHistoryList.get(2).status);
	}

}
