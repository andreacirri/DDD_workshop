package com.ddd.workshop.cqrs.domain.query;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class ReservationAmount {
	
	private BigDecimal amount;

	public ReservationAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ReservationAmount that = (ReservationAmount) o;
		return Objects.equals(amount, that.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ReservationAmount.class.getSimpleName() + "[", "]").add("amount=" + amount)
				.toString();
	}

}
