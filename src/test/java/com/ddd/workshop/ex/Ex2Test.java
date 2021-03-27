package com.ddd.workshop.ex;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class Ex2Test {

	@Test
	public void Should_ReserveSeat_When_SeatsAreAvailable(){
		// given

		Seat seat = new Seat(1L);
		ArrayList<Seat> seats = new ArrayList<>();
		seats.add(seat);

		List<Event> events = new ArrayList<>();
		events.add(new Screening_Created(seats));

		//when

		ReserveSeats reserveSeats = new ReserveSeats(seats);

		CommandHandler commandHandler = new CommandHandler();
		List<Event> result = commandHandler.handle(events, reserveSeats);

		//expected

		assertThat(result, hasItem(new Seat_Reserved(seats)));

	}

	@Test
	public void Should_NotReserveSeat_When_SeatsAreNotAvailable(){
		// given
		Seat seat = new Seat(1L);
		ArrayList<Seat> seats = new ArrayList<>();
		seats.add(seat);

		List<Event> events = new ArrayList<>();
		events.add(new Screening_Created(seats));


		events.add(new Seat_Reserved(seats));

		//when

		ReserveSeats reserveSeats = new ReserveSeats(seats);

		CommandHandler commandHandler = new CommandHandler();
		List<Event> result = commandHandler.handle(events, reserveSeats);

		//expected

		assertThat(result, hasItem(new Seat_Not_Reserved()));

	}

	@Test
	public void Should_ReturnFreeSeats(){
		// given
		Seat seat = new Seat(1L);
		Seat seat2 = new Seat(2L);
		Seat seat3 = new Seat(3L);
		ArrayList<Seat> seats = new ArrayList<>();
		seats.add(seat);
		seats.add(seat2);
		seats.add(seat3);

		List<Event> events = new ArrayList<>();
		events.add(new Screening_Created(seats));

		ArrayList<Seat> reserved = new ArrayList<>();
		reserved.add(seat);

		events.add(new Seat_Reserved(reserved));

		ScreeningReadModel screeningReadModel = new ScreeningReadModel(events);
		SeatQueryHandler seatQueryHandler = new SeatQueryHandler(screeningReadModel);

		List<Seat> freeSeats = seatQueryHandler.query(new SeatAvailableQuery());

		//expected
		ArrayList<Seat> expectedFree = new ArrayList<>();
		expectedFree.add(seat2);
		expectedFree.add(seat3);

		assertThat(freeSeats, is(expectedFree));

	}

	private class CommandHandler {

		List<Event> handle(List<Event> events, ReserveSeats reserveSeats) {
			return new Ex2Test.Screening(events).reserveSeats(reserveSeats.seats);
		}
	}

	private class SeatAvailableQuery {
	}

	private class SeatQueryHandler {

		private ScreeningReadModel screeningReadModel;

		public SeatQueryHandler(ScreeningReadModel screeningReadModel) {
			this.screeningReadModel = screeningReadModel;
		}

		public List<Seat> query(SeatAvailableQuery query) {
			return screeningReadModel.freeSeats();
		}
	}

	private class ScreeningReadModel {

		Map<Seat, Boolean> reservatedSeats;

		public ScreeningReadModel(List<Event> events) {
			events.forEach(event -> this.apply(event));
		}

		public List<Seat> freeSeats(){
			List<Seat> freeSeats = new ArrayList<>();
			reservatedSeats.forEach((seat, aBoolean) -> {
				if (!aBoolean){
					freeSeats.add(seat);
				}
			});
			return freeSeats;
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

			reservatedSeats = new HashMap<>();
			event.available.forEach(seat -> reservatedSeats.put(seat, false));
		}

		void apply(Seat_Reserved event){
			event.seats.forEach(seat -> reservatedSeats.put(seat, true));
		}

	}

	private class Screening {

		Set<Seat> seats;
		LocalDateTime startTime;

		public Screening(List<Event> events) {
			events.forEach(event -> this.apply(event));
		}

		public List<Event> reserveSeats(List<Seat> seats){

			List<Event> events = new ArrayList<>();

			boolean seatsAvailable = seats.stream().noneMatch(seat -> this.seats.contains(seat));

			if (seatsAvailable) {
				events.add(new Seat_Reserved(seats));
			} else {
				events.add(new Seat_Not_Reserved());
			}

			return events;
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

	private class Event {

	}

	private class Screening_Created extends Event {

		List<Seat> available;

		public Screening_Created(List<Seat> available) {
			this.available = available;
		}
	}

	private class Seat_Not_Reserved extends Event {
	}

	private class Seat_Reserved extends Event{

		public List<Seat> seats;

		public Seat_Reserved(List<Seat> seats) {
			this.seats = seats;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Seat_Reserved that = (Seat_Reserved) o;
			return Objects.equals(seats, that.seats);
		}

		@Override
		public int hashCode() {
			return Objects.hash(seats);
		}
	}

	private class ReserveSeats {
		public List<Seat> seats;

		public ReserveSeats(List<Seat> seats) {
			this.seats = seats;
		}
	}

	private class Seat {

		public Long id;

		public Seat(Long id) {
			this.id = id;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Seat seat = (Seat) o;
			return Objects.equals(id, seat.id);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
	}
}
