package com.chat.service.hackathon.pojo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class Data {
	public Map<String, String> getFacebook() {
		return facebook;
	}
	public void setFacebook(Map<String, String> facebook) {
		this.facebook = facebook;
	}
	public String getSender_action() {
		return sender_action;
	}
	public void setSender_action(String sender_action) {
		this.sender_action = sender_action;
	}
	private Map<String,String> facebook;
	private String sender_action;
}
