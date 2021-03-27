package com.ddd.workshop.cqrs.infrastructure;

import com.ddd.workshop.cqrs.domain.aggregate.ScreeningReadModel;
import com.ddd.workshop.cqrs.domain.query.FreeSeatsQuery;
import com.ddd.workshop.cqrs.domain.query.FreeSeatsResponse;

public class QueryHandler {
	Action<Object> _respond;
	ScreeningReadModel _readModel;

	// readModel needs to be a specific class ( with query methods)
	public QueryHandler(ScreeningReadModel readModel, Action<Object> respond) {
		_respond = respond;
		this._readModel = readModel;
	}

	public void query(Object query) {

		if (query instanceof FreeSeatsQuery) {
			_respond.publish(new FreeSeatsResponse(_readModel.freeSeats()));
		}
	}

}

