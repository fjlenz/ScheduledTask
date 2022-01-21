package com.fj.ScheduledTask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageModel   {

	@JsonProperty(value = "id", required = true)
	private Long id;

	@JsonProperty(value = "message", required = true)
	private String message = null;

	@JsonProperty(value = "rating", required = false)
	private Integer rating = 1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
