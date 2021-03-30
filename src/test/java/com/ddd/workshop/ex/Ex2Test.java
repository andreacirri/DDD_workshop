package com.ddd.workshop.ex;

import com.ddd.workshop.cqrs.domain.command.Reserve_Seats;
import com.ddd.workshop.cqrs.domain.event.Seat_Not_Reserved;
import com.ddd.workshop.cqrs.domain.event.Seat_Reserved;
import com.ddd.workshop.cqrs.domain.obj.Seat;
import com.ddd.workshop.cqrs.domain.query.FreeSeatsQuery;
import com.ddd.workshop.cqrs.domain.query.FreeSeatsResponse;
import org.junit.Test;

import java.util.List;

public class Ex2Test extends BaseTest {

	final Seat seat1 = new Seat(1L);
	final Seat seat2 = new Seat(2L);
	final Seat seat3 = new Seat(3L);

//	@Test
//	public void Should_ReserveSeat_When_SeatsAreAvailable() {
//
//		Given(new Screening_Created(List.of(seat1)));
//
//		When(new Reserve_Seats(List.of(seat1)));
//
//		Then_expect(new Seat_Reserved(List.of(seat1)));
//
//	}
//
//	@Test
//	public void Should_NotReserveSeat_When_SeatsAreNotAvailable() {
//
//		Given(
//				new Screening_Created(List.of(seat1)),
//				new Seat_Reserved(List.of(seat1))
//		);
//
//		When(
//				new Reserve_Seats(List.of(seat1))
//		);
//
//		Then_expect(
//				new Seat_Not_Reserved()
//		);
//
//	}
//
//	@Test
//	public void Should_ReturnFreeSeats() {
//
//		Given(
//				new Screening_Created(List.of(seat1, seat2, seat3)),
//				new Seat_Reserved(List.of(seat1))
//		);
//
//		Query(
//				new FreeSeatsQuery()
//		);
//
//		Then_expected_response(
//				new FreeSeatsResponse(List.of(seat2, seat3))
//		);
//
//	}

}
