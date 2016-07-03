package com.my.rest.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.rest.dao.EventService;
import com.my.rest.dao.TagService;
import com.my.rest.entity.RequestModel;
import com.my.rest.entity.ResponseModel;
import com.my.rest.entity.TagModel;
import com.my.rest.model.Event;
import com.my.rest.model.Tag;


@Controller
@RequestMapping("/rest/tags/")
public class TagsController {

	private TagService tagService;
	
	private EventService eventService;
	
	private static final Logger logger = LoggerFactory.getLogger(TagsController.class);
	
	@Autowired
	public TagsController(TagService tagService, EventService eventService) {
		this.tagService = tagService;
		this.eventService = eventService;
	}
	
	@RequestMapping(value="/increaseWeight/{tagId}", method = RequestMethod.POST)
	public @ResponseBody RequestModel increaseWeight(@PathVariable Integer tagId) {
		Tag tag = tagService.getTag(tagId);
		tag.setWeight(tag.getWeight() + 1);
		tagService.updateTag(tag);
		RequestModel rm = new RequestModel();
		return rm;
		
	}
	
	@RequestMapping(value="/decreaseWeight/{tagId}", method = RequestMethod.POST)
	public @ResponseBody RequestModel decreaseWeight(@PathVariable Integer tagId) {
		Tag tag = tagService.getTag(tagId);
		tag.setWeight(tag.getWeight() - 1);
		tagService.updateTag(tag);
		RequestModel rm = new RequestModel();
		return rm;
		
	}
	
	@RequestMapping(value="/createTag", method = RequestMethod.POST)
	public @ResponseBody RequestModel createTag(@RequestBody RequestModel model) {
		logger.info("Uso je!");
		Event event = eventService.findEvent(model.getEventId());
		Tag tag = new Tag();
		tag.setValue(model.getValue());
		tag.setWeight(1);
		if(event != null) {
			logger.info("Event nije null");
		}
		else {
			logger.info("Event je null");
			event = new Event();
			event.setEvent_Id(model.getEventId());
			event.setVenue_Id(model.getVanueId());
			eventService.createEvent(event);
		}
		tag.setEvent(event);
		tagService.createTag(tag);
		return model;
	}
	
	@RequestMapping(value="/getTagsEvent/{eventId}", method = RequestMethod.GET)
	public @ResponseBody ResponseModel getTagsEvent(@PathVariable String eventId) {
		List<Tag> tagsTemp = tagService.getAllEventTags(eventId);
		List<TagModel> tags = new ArrayList<TagModel>();
		for(Tag t:tagsTemp) {
			TagModel tag = new TagModel();
			tag.setEventId(t.getEvent().getEvent_Id());
			tag.setVanueId(t.getEvent().getVenue_Id());
			tag.setWeight(t.getWeight());
			tag.setValue(t.getValue());
			tags.add(tag);
		}
		ResponseModel responseModel = new ResponseModel();
		responseModel.setTags(tags);
		return responseModel;
		
	}
	
	@RequestMapping(value="/getTagsVanue/{vanueId}", method = RequestMethod.GET)
	public @ResponseBody ResponseModel getTagsVanue(@PathVariable String vanueId) {
		List<Tag> tagsTemp = tagService.getAllVanueTags(vanueId);
		List<TagModel> tags = new ArrayList<TagModel>();
		for(Tag t:tagsTemp) {
			TagModel tag = new TagModel();
			tag.setEventId(t.getEvent().getEvent_Id());
			tag.setVanueId(t.getEvent().getVenue_Id());
			tag.setWeight(t.getWeight());
			tag.setValue(t.getValue());
			tags.add(tag);
		}
		ResponseModel responseModel = new ResponseModel();
		responseModel.setTags(tags);
		return responseModel;
		
	}
	
	@RequestMapping(value="/getAllTags", method = RequestMethod.GET)
	public @ResponseBody List<TagModel> getAllTags() {
		List<Tag> tagsTemp = tagService.getAll();
		List<TagModel> tags = new ArrayList<TagModel>();
		for(Tag t:tagsTemp) {
			TagModel tag = new TagModel();
			tag.setEventId(t.getEvent().getEvent_Id());
			tag.setVanueId(t.getEvent().getVenue_Id());
			tag.setWeight(t.getWeight());
			tag.setValue(t.getValue());
			tag.setTagId(t.getInternal_tag_Id());
			tags.add(tag);
		}
		ResponseModel responseModel = new ResponseModel();
		responseModel.setTags(tags);
		return tags;
	}
	
}
