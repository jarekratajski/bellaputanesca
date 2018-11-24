package com.julian.bella.api.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderFinancesDto {

	private Long orderId;
	private BigDecimal finalPrice = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal estimatedPrice = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal finalExpense = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	private BigDecimal estimatedExpense = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

	public Long getOrderId() {
		return orderId;
	}

	public OrderFinancesDto setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public OrderFinancesDto setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
		return this;
	}

	public BigDecimal getEstimatedPrice() {
		return estimatedPrice;
	}

	public OrderFinancesDto setEstimatedPrice(BigDecimal estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
		return this;
	}

	public BigDecimal getFinalExpense() {
		return finalExpense;
	}

	public OrderFinancesDto setFinalExpense(BigDecimal finalExpense) {
		this.finalExpense = finalExpense;
		return this;
	}

	public BigDecimal getEstimatedExpense() {
		return estimatedExpense;
	}

	public OrderFinancesDto setEstimatedExpense(BigDecimal estimatedExpense) {
		this.estimatedExpense = estimatedExpense;
		return this;
	}

}
