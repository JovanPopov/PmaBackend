package com.my.rest.entity;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {

	private List<TagModel> tags = new ArrayList<TagModel>();

	public List<TagModel> getTags() {
		return tags;
	}

	public void setTags(List<TagModel> tags) {
		this.tags = tags;
	}
	
}
