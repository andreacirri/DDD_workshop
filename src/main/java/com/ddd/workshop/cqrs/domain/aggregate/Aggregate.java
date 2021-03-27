package com.ddd.workshop.cqrs.domain.aggregate;

import java.util.List;

public class Aggregate {

	private List<Object> events;

	public Aggregate(List<Object> events) {
		this.events = events;
		this.events.forEach(event -> this.apply(event));
	}

	public void OnEvent(Object e) {
		apply(e);
	}

	private void apply(Object e) {
	}
}
