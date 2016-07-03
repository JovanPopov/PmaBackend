package com.my.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.my.rest.model.Event;

@Repository
public class JpaEventRepo implements EventRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Event findEvent(String event_Id) {
		@SuppressWarnings("unchecked")
		List<Event> events = em.createQuery("select e from Event e where e.event_Id = :id" ).setParameter("id", event_Id).getResultList();
		if(events.size() != 0){
			Event event = events.get(0);
			return event;
		}
		else {
			return null;
		}
	}
	
	public void createEvent(Event event) {
		em.persist(event);
	}

	@Override
	public void updateEvent(Event newEvent) {
		em.merge(newEvent);
	}

}
