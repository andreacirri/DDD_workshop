package com.ddd.workshop.cqrs.infrastructure;

import com.ddd.workshop.cqrs.domain.aggregate.PendingReservation;
import com.ddd.workshop.cqrs.domain.query.ReservationAmountQuery;

public class QueryHandler {
	Action<Object> _respond;
	PendingReservation _readModel;

	// readModel needs to be a specific class ( with query methods)
	public QueryHandler(PendingReservation readModel, Action<Object> respond) {
		_respond = respond;
		this._readModel = readModel;
	}

	public void query(Object query) {

		if (query instanceof ReservationAmountQuery) {

			// TODO
			// _respond.publish(new ReservationAmount(_readModel.evalAmount(query)));
		}
	}

}

