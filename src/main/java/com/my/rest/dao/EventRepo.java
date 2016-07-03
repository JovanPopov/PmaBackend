package com.my.rest.dao;

import com.my.rest.model.Event;

public interface EventRepo {
	
	public Event findEvent(String event_Id);
	public void createEvent(Event event);
	public void updateEvent(Event newEvent);
}
