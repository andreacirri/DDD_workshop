package com.ddd.workshop.ex;

import com.ddd.workshop.cqrs.infrastructure.CommandHandler;
import com.ddd.workshop.cqrs.infrastructure.QueryHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseTest {
	List<Object> _history;
	List<Object> _published_events;
	Object _query_response;
	Object _read_model;

	void Given(Object ...events) { //Provide a history of the events for the commandhandler
		_history = new ArrayList<>();
		Arrays.stream(events).forEach(event -> _history.add(event));
	}

	void When(Object cmd) { //Instanitate the commandhandler and give it the command
		CommandHandler handler = new CommandHandler(_history, e -> _published_events.add(e));
		handler.handle(cmd);
	}

	void Then_expect(Object ...events){ // -> //Compare the published events with the expected events
		assertThat(_published_events, is(events));
	}

	void Then_expected_response(Object expected_response){
		assertThat(_query_response, is(expected_response));
	}

	public void Query(Object query) {
		// create read model
		// _readmodel = new Customer_Reservations_ReadModel(_history);
		QueryHandler handler = new QueryHandler(_read_model, (q -> _query_response = q));
		handler.query(query);
	}
}


