package com.ddd.workshop.cqrs.infrastructure;

import java.util.List;

public class CommandHandler {

	private List<Object> history;
	private Action<Object> action;

	public CommandHandler(List<Object> history, Action<Object> action) {
		this.history = history;
		this.action = action;
	}

	public void handle(Object cmd) {

	}
}
