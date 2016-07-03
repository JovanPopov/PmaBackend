package com.my.rest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.my.rest.model.Event;
import com.my.rest.model.Tag;

@Repository
public class JpaTagRepo implements TagRepo {

	@PersistenceContext
	private EntityManager em;
	
	public List<Tag> getAllEventTags(String event_Id) {
		Event event;
		@SuppressWarnings("unchecked")
		List<Event> events = em.createQuery("select e from Event e where e.event_Id = :id" ).setParameter("id", event_Id).getResultList();
		if(events.size() != 0 ) {
			event = events.get(0);
			List<Tag> list= new ArrayList<Tag>();
			list.addAll(event.getTags());
			return list;
		}
		
		else {
			List<Tag> empty = new ArrayList<Tag>();
			return empty;
		}
	}
	
	public List<Tag> getAllVanueTags(String vanue_Id) {
		@SuppressWarnings("unchecked")
		List<Event> events = em.createQuery("select e from  Event e where e.venue_Id = :venue_Id" ).setParameter("venue_Id", vanue_Id).getResultList();
		
		if(events.size() != 0) {
			List<Tag> results = new ArrayList<Tag>();
			for(Event event : events) {
				List<Tag> list= new ArrayList<Tag>();
				list.addAll(event.getTags());
				results.addAll(list);
			}		
			return results;
		}
		else {
			List<Tag> empty = new ArrayList<Tag>();
			return empty;
		}
	}

	@Override
	public void createTag(Tag tag) {
		 em.persist(tag);
	}
	
	public Tag getTag(int tagId) {
		return em.find(Tag.class, tagId);
	}

	@Override
	public void updateTag(Tag newTag) {
		// TODO Auto-generated method stub
		em.merge(newTag);
	}
	
	public List<Tag> getAll() {
		 @SuppressWarnings("unchecked")
		List<Tag> tags = em.createQuery("select t from Tag t" ).getResultList();
		 if(tags.size() != 0)
			 return tags;
		 else {
			 List<Tag> empty = new ArrayList<Tag>();
		     return empty;
		 }
	}
}
