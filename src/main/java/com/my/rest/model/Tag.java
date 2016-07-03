package com.my.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Tag")
public class Tag implements java.io.Serializable{
	
	@Id 
	@GeneratedValue
	@Column(name = "internal_tag_Id",nullable = false)
	private int internal_tag_Id;
	
	@Column(name = "weight",nullable = true)
	private int weight;
	
	@Column(name = "value",nullable = false)
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "internal_event_Id")
	private Event event;

	public int getInternal_tag_Id() {
		return internal_tag_Id;
	}

	public void setInternal_tag_Id(int internal_tag_Id) {
		this.internal_tag_Id = internal_tag_Id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
