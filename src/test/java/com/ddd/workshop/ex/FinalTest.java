package com.ddd.workshop.ex;

import com.ddd.workshop.cqrs.domain.aggregate.Screening;
import com.ddd.workshop.cqrs.domain.command.ChooseScreening;
import com.ddd.workshop.cqrs.domain.event.CinemaCreated;
import com.ddd.workshop.cqrs.domain.event.ScreeningChosen;
import com.ddd.workshop.cqrs.domain.command.ReserveSeats;
import com.ddd.workshop.cqrs.domain.event.ScreeningScheduled;
import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;
import com.ddd.workshop.cqrs.domain.obj.Movie;
import com.ddd.workshop.cqrs.domain.obj.Person;
import com.ddd.workshop.cqrs.domain.obj.Seat;
import com.ddd.workshop.cqrs.domain.query.ReservationAmount;
import com.ddd.workshop.cqrs.domain.query.ReservationAmountQuery;
import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinalTest extends BaseTest {

	@Test
	public void Should_ReserveSeatsForASpecificPerson() {

		Given(
				new ScreeningScheduled(1L, movie1(), BigDecimal.ONE, LocalDateTime.now(), List.of(seat1(), seat2(), seat3()))
		);

		When(
				new ReserveSeats(List.of(seat1()), PersonAC())
		);

		Then_expect(
				new Seat_Reserved(List.of(seat1()), PersonAC())
		);

	}

	@Test
	public void Should_GetAmountAfterReservation() {

		Given(
				new ScreeningScheduled(1L, movie1(), BigDecimal.ONE, LocalDateTime.now(), List.of(seat1(), seat2(), seat3())),
				new Seat_Reserved(List.of(seat1()), PersonAC())
		);

		Query(
				new ReservationAmountQuery(PersonAC(), 1L)
		);

		Then_expected_response(
				new ReservationAmount(BigDecimal.ONE)
		);

	}

	private Person PersonAC() {
		return new Person("A", "C");
	}

	private Movie movie1(){
		return new Movie("1");
	}

	private Seat seat1(){
		return new Seat(1L);
	}

	private Seat seat2(){
		return new Seat(2L);
	}

	private Seat seat3(){
		return new Seat(3L);
	}

}
