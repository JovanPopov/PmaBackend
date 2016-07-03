package com.my.rest.model;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Event")
public class Event implements java.io.Serializable {

	
	@Id 
	@GeneratedValue
	@Column(name = "internal_event_Id",nullable = false)
	private int internal_event_Id;
	
	@Column(name = "event_Id",nullable = false)
	private String event_Id;
	
	@Column(name = "venue_Id",nullable = false)
	private String venue_Id;
	
	@OneToMany(mappedBy = "event")
	public java.util.Set<Tag> tags = new HashSet<Tag>();

	public int getInternal_event_Id() {
		return internal_event_Id;
	}

	public void setInternal_event_Id(int internal_event_Id) {
		this.internal_event_Id = internal_event_Id;
	}

	public String getEvent_Id() {
		return event_Id;
	}

	public void setEvent_Id(String event_Id) {
		this.event_Id = event_Id;
	}

	public String getVenue_Id() {
		return venue_Id;
	}

	public void setVenue_Id(String venue_Id) {
		this.venue_Id = venue_Id;
	}

	public java.util.Set<Tag> getTags() {
		return tags;
	}

	public void setTags(java.util.Set<Tag> tags) {
		this.tags = tags;
	}
	
	
}
