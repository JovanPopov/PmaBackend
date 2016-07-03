package com.my.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.rest.model.Tag;


@Service
@Transactional
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagRepo repo;
	
	@Override
	public List<Tag> getAllEventTags(String event_Id) {
		// TODO Auto-generated method stub
		return repo.getAllEventTags(event_Id);
	}

	@Override
	public List<Tag> getAllVanueTags(String vanue_Id) {
		// TODO Auto-generated method stub
		return repo.getAllVanueTags(vanue_Id);
	}

	@Override
	public void createTag(Tag tag) {
		// TODO Auto-generated method stub
		 repo.createTag(tag);
	}

	@Override
	public void updateTag(Tag newTag) {
		// TODO Auto-generated method stub
		repo.updateTag(newTag);
	}

	@Override
	public List<Tag> getAll() {
		// TODO Auto-generated method stub
		return repo.getAll();
	}

	@Override
	public Tag getTag(int tagId) {
		// TODO Auto-generated method stub
		return repo.getTag(tagId);
	}

}
