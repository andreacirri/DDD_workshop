package com.ddd.workshop.cqrs.domain.aggregate;

import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;
import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningReadModel {

	Map<Seat, Boolean> reservedSeats;

	public ScreeningReadModel(List<Object> events) {
//		events.forEach(event -> this.apply(event));
	}

	public List<Seat> freeSeats(){
		List<Seat> freeSeats = new ArrayList<>();
		reservedSeats.forEach((seat, aBoolean) -> {
			if (!aBoolean){
				freeSeats.add(seat);
			}
		});
		return freeSeats;
	}

//	void apply(Object event){
//		if (event instanceof Screening_Created) {
//			apply((Screening_Created) event);
//		}
//
//		if (event instanceof Seat_Reserved) {
//			apply((Seat_Reserved) event);
//		}
//	}
//
//	void apply(Screening_Created event){
//
//		reservedSeats = new HashMap<>();
//		event.availableSeats.forEach(seat -> reservedSeats.put(seat, false));
//	}

	void apply(Seat_Reserved event){
		event.seats.forEach(seat -> reservedSeats.put(seat, true));
	}

}
