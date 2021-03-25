package com.ddd.workshop.ex1;

import com.ddd.workshop.ex1.aggregate.Screening;
import com.ddd.workshop.ex1.command.ReservationCommand;
import com.ddd.workshop.ex1.handler.ReservationHandler;
import com.ddd.workshop.ex1.repository.ReservationRepositoryInterface;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Ex1Test {

	class TestReservationRepository implements ReservationRepositoryInterface {

		Screening screening;

		public TestReservationRepository(Screening screening) {
			this.screening = screening;
		}

		@Override
		public Screening get() {
			return screening;
		}
	}

	@Test
	public void Should_ReserveSeat_When_SeatsAreAvailable(){

		final int availableSeats = 2;
		ReservationCommand reservationCommand = ReservationCommand.of(2);
		TestReservationRepository repository = new TestReservationRepository(Screening.of(availableSeats));

		ReservationHandler reservationHandler = new ReservationHandler(repository);
		reservationHandler.handle(reservationCommand);

		assertThat(repository.get(), is(Screening.of(availableSeats - reservationCommand.seats)));
	}

	@Test
	public void Should_FailToReserveSeat_When_SeatsAreNotAvailable(){

		final int availableSeats = 1;
		ReservationCommand reservationCommand = ReservationCommand.of(2);
		TestReservationRepository repository = new TestReservationRepository(Screening.of(availableSeats));

		ReservationHandler reservationHandler = new ReservationHandler(repository);
		reservationHandler.handle(reservationCommand);

		assertThat(repository.get(), is(Screening.of(availableSeats)));
	}

}
