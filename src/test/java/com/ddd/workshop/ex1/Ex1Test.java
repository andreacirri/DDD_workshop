package com.ddd.workshop.ex1;

import com.ddd.workshop.ex1.aggregate.Screening;
import com.ddd.workshop.ex1.command.ReservationCommand;
import com.ddd.workshop.ex1.handler.ReservationHandler;
import com.ddd.workshop.ex1.model.ReservationResult;
import com.ddd.workshop.ex1.repository.ReservationRepositoryInterface;
import org.junit.Test;

import static com.ddd.workshop.ex1.model.ReservationResult.FAIL;
import static com.ddd.workshop.ex1.model.ReservationResult.SUCCESS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Ex1Test {

	static class TestReservationRepository implements ReservationRepositoryInterface {

		Screening screening;

		public static TestReservationRepository of(Screening screening) {
			return new TestReservationRepository(screening);
		}

		private TestReservationRepository(Screening screening) {
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
		ReservationRepositoryInterface repository = TestReservationRepository.of(Screening.of(availableSeats));

		ReservationHandler.of(repository).handle(reservationCommand);

		assertThat(repository.get(), is(Screening.of(availableSeats - reservationCommand.seats)));
	}

	@Test
	public void Should_FailToReserveSeat_When_SeatsAreNotAvailable(){

		final int availableSeats = 1;
		ReservationCommand reservationCommand = ReservationCommand.of(2);
		ReservationRepositoryInterface repository = TestReservationRepository.of(Screening.of(availableSeats));

		ReservationHandler.of(repository).handle(reservationCommand);

		assertThat(repository.get(), is(Screening.of(availableSeats)));
	}

	@Test
	public void Should_GetSuccess_When_SeatsAreAvailable(){

		final int availableSeats = 2;
		ReservationCommand reservationCommand = ReservationCommand.of(2);
		ReservationRepositoryInterface repository = TestReservationRepository.of(Screening.of(availableSeats));

		ReservationResult reservationResult = ReservationHandler.of(repository).handle(reservationCommand);

		assertThat(reservationResult, is(SUCCESS));
	}

	@Test
	public void Should_GetFail_When_SeatsAreNotAvailable(){

		final int availableSeats = 1;
		ReservationCommand reservationCommand = ReservationCommand.of(2);
		ReservationRepositoryInterface repository = TestReservationRepository.of(Screening.of(availableSeats));

		ReservationResult reservationResult = ReservationHandler.of(repository).handle(reservationCommand);

		assertThat(reservationResult, is(FAIL));
	}

}
