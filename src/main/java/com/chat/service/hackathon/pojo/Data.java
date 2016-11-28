package com.chat.service.hackathon.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class Data {
	private Facebook facebook;
	public Facebook getFacebook() {
		return facebook;
	}
	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}
	public String getSender_action() {
		return sender_action;
	}
	public void setSender_action(String sender_action) {
		this.sender_action = sender_action;
	}
	private String sender_action;
}
