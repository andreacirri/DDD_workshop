package com.ddd.workshop.cqrs.infrastructure;

import com.ddd.workshop.cqrs.domain.aggregate.Screening;
import com.ddd.workshop.cqrs.domain.command.Reserve_Seats;

import java.util.List;

public class CommandHandler {

	private List<Object> history;
	private Action<Object> action;

	public CommandHandler(List<Object> history, Action<Object> action) {
		this.history = history;
		this.action = action;
	}

	public void handle(Object cmd) {

		if (cmd instanceof Reserve_Seats) {
			new Screening(history, addHistoryAndPublish()).reserveSeats(((Reserve_Seats) cmd).seats);
		}

	}

	private Action<Object> addHistoryAndPublish() {
		return a -> {
			history.add(a);
			action.publish(a);
		};
	}
}
