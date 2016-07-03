package com.my.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.rest.model.Event;

@Service
@Transactional
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepo repo;
	
	@Override
	public Event findEvent(String event_Id) {
		// TODO Auto-generated method stub
		return repo.findEvent(event_Id);
	}

	@Override
	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		repo.createEvent(event);
	}

	@Override
	public void updateEvent(Event newEvent) {
		// TODO Auto-generated method stub
		repo.updateEvent(newEvent);
	}

}
