package com.fj.ScheduledTask.entity;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field;

import org.springframework.data.annotation.Id;

@Entity(name = "msg_message")
public class Message {

    @Id
    private Long id;

	@Field(name = "msg_text")
    private String text;

	@Field(name = "msg_rating")
    private Integer rating;
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
    public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
    
}