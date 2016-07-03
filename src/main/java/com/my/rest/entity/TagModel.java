package com.my.rest.entity;

public class TagModel {
	
	private int tagId;
	
	private String eventId;
	
	private String vanueId;
	
	private int weight;

	private String value;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getVanueId() {
		return vanueId;
	}

	public void setVanueId(String vanueId) {
		this.vanueId = vanueId;
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

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	
}
