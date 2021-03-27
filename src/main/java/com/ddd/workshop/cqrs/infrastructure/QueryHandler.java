package com.ddd.workshop.cqrs.infrastructure;

public class QueryHandler {
	Action<Object> _respond;
	Object _reservations;

	// readModel needs to be a specific class ( with query methods)
	public QueryHandler(Object readModel, Action<Object> respond) {
		_respond = respond;
		_reservations = readModel;
	}

	public void query(Object query) {
		// eval from read model
		// _respond.publish(new My_Reservations_Respone() {});
	}

}
