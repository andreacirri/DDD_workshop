package com.ddd.workshop.cqrs.domain.aggregate;

import com.ddd.workshop.cqrs.domain.event.ScreeningChosen;
import com.ddd.workshop.cqrs.domain.event.ScreeningScheduled;
import com.ddd.workshop.cqrs.domain.event.Seat_Not_Reserved;
import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;
import com.ddd.workshop.cqrs.domain.obj.Movie;
import com.ddd.workshop.cqrs.domain.obj.Person;
import com.ddd.workshop.cqrs.domain.obj.Seat;
import com.ddd.workshop.cqrs.infrastructure.Action;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Screening {

	private Long id;
	private Movie movie;
	private BigDecimal price;
	private LocalDateTime time;
	private Map<Person, Seat> reservervations;
	private Set<Seat> seats;

	private Action<Object> action;

	public Screening(List<Object> events, Action<Object> action) {
		this.action = action;
		events.forEach(event -> this.apply(event));
	}

	void apply(Object event){

		if (event instanceof ScreeningScheduled){
			apply((ScreeningScheduled) event);
		}
	}

	public void reserveSeats(List<Seat> seats, Person person){
		boolean seatsAvailable = reservervations.values().stream().noneMatch(seat -> this.seats.contains(seat));

		if (seatsAvailable) {
			action.publish(new Seat_Reserved(seats, person));
		} else {
			action.publish(new Seat_Not_Reserved());
		}
	}


	void apply(ScreeningScheduled event){
		movie = event.movie();
		price = event.price();
		time = event.time();
		seats = event.getSeats();
		reservervations = new HashMap<>();
	}


}
