package com.my.rest.dao;

import java.util.List;

import com.my.rest.model.Tag;

public interface TagRepo {

	public List<Tag> getAllEventTags(String event_Id);
	public List<Tag> getAllVanueTags(String vanue_Id);
	public void createTag(Tag tag);
	public void updateTag(Tag newTag);
	public List<Tag> getAll();
	public Tag getTag(int tagId);
}
