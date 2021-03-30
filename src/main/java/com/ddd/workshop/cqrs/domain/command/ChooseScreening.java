package com.ddd.workshop.cqrs.domain.command;

public class ChooseScreening {

	private Long id;

	public ChooseScreening(Long id) {
		this.id = id;
	}

	public Long id() {
		return id;
	}
}
