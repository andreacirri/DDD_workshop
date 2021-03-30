package com.ddd.workshop.cqrs.infrastructure;

import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;

import java.util.List;

public class EventHandler {

	private List<Object> history;
	private Action<Object> emitComand;

	public EventHandler(List<Object> history, Action<Object> emit_command) {
		this.history = history;
		this.emitComand = emit_command;
	}

	public void handle(Object event) {

		if (event instanceof Seat_Reserved) {

			// without constraint, only reaction
			//emitComand.publish(new Event());

			//--------

			// with domain constraint to check

			//Aggregate aggregate = new Aggregate(history, addHistoryAndPublish());
			//aggregate.method()
		}

	}

	private Action<Object> addHistoryAndPublish() {
		return a -> {
			history.add(a);
			emitComand.publish(a);
		};
	}
}
