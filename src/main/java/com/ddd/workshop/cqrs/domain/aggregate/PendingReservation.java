package com.ddd.workshop.cqrs.domain.aggregate;

import java.util.List;

public class PendingReservation {

	public PendingReservation(List<Object> events) {
		events.forEach(event -> this.apply(event));
	}

	private void apply(Object event) {
	}
}
