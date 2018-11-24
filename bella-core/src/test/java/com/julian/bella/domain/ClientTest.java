package com.julian.bella.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.julian.bella.domain.Client;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.OrderStatus;

public class ClientTest {

	@Test
	public void testUpdateOrderStatus() {
		// given
		Client client = new Client();
		
		Order order = new Order();	
		order.getFinances().setFinalPrice(new BigDecimal(100));
		order.getFinances().setFinalExpense(new BigDecimal(10));
		
		order.addClient(client);
			
		// when
		long numberBefore = client.getFinishedOrdersNumber();
		BigDecimal profitBefore = client.getFinishedOrdersProfit();
		
		order.updateStatus(OrderStatus.SUCCESSFULLY_FINISHED);
		
		long numberAfter = client.getFinishedOrdersNumber();
		BigDecimal profitAfter = client.getFinishedOrdersProfit();
		
		// then
		assertEquals(0, numberBefore);
		assertEquals(1, numberAfter);
		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), profitBefore);
		assertEquals(new BigDecimal("90").setScale(2, RoundingMode.HALF_UP), profitAfter);
		
		// when 
		order.updateStatus(OrderStatus.SUCCESSFULLY_FINISHED);
		
		numberAfter = client.getFinishedOrdersNumber();
		profitAfter = client.getFinishedOrdersProfit();
		
		// then
		assertEquals(0, numberBefore);
		assertEquals(1, numberAfter);
		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), profitBefore);
		assertEquals(new BigDecimal("90").setScale(2, RoundingMode.HALF_UP), profitAfter);
	}

}
