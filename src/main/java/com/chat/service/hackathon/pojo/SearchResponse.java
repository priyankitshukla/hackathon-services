package com.chat.service.hackathon.pojo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class SearchResponse {
	
	private String speech;
	private String displayText;
	private Map<String,Facebook> data;
	private String contextOut;
	
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	
	
	public Map<String, Facebook> getData() {
		return data;
	}
	public void setData(Map<String, Facebook> data) {
		this.data = data;
	}
	public String getContextOut() {
		return contextOut;
	}
	public void setContextOut(String contextOut) {
		this.contextOut = contextOut;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	private String source;

}
