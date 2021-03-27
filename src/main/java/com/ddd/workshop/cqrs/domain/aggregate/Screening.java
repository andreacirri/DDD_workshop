package com.ddd.workshop.cqrs.domain.aggregate;

import com.ddd.workshop.cqrs.domain.command.Reserve_Seats;
import com.ddd.workshop.cqrs.domain.event.Screening_Created;
import com.ddd.workshop.cqrs.domain.event.Seat_Not_Reserved;
import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;
import com.ddd.workshop.cqrs.domain.obj.Seat;
import com.ddd.workshop.cqrs.infrastructure.Action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Screening {

	private Set<Seat> seats;
	private Action<Object> action;

	public Screening(List<Object> events, Action<Object> action) {
		this.action = action;
		events.forEach(event -> this.apply(event));
	}

	public void reserveSeats(List<Seat> seats){
		boolean seatsAvailable = seats.stream().noneMatch(seat -> this.seats.contains(seat));

		if (seatsAvailable) {
			action.publish(new Seat_Reserved(seats));
		} else {
			action.publish(new Seat_Not_Reserved());
		}
	}

	void apply(Object event){
		if (event instanceof Screening_Created) {
			apply((Screening_Created) event);
		}

		if (event instanceof Seat_Reserved) {
			apply((Seat_Reserved) event);
		}
	}

	void apply(Screening_Created event){
		seats = new HashSet<>();
	}

	void apply(Seat_Reserved event){
		seats.addAll(event.seats);
	}


}
