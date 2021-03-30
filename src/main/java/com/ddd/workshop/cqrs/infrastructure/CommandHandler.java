package com.ddd.workshop.cqrs.infrastructure;

import com.ddd.workshop.cqrs.domain.aggregate.Screening;
import com.ddd.workshop.cqrs.domain.command.ReserveSeats;

import java.util.List;

public class CommandHandler {

	private List<Object> history;
	private Action<Object> action;

	public CommandHandler(List<Object> history, Action<Object> action) {
		this.history = history;
		this.action = action;
	}

	public void handle(Object cmd) {

		if (cmd instanceof ReserveSeats) {
			Screening screening = new Screening(history, addHistoryAndPublish());
			screening.reserveSeats(((ReserveSeats) cmd).getSeats(), ((ReserveSeats) cmd).getPerson());
		}

	}

	private Action<Object> addHistoryAndPublish() {
		return a -> {
			history.add(a);
			action.publish(a);
		};
	}
}
