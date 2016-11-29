package com.chat.service.hackathon.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class Facebook {
		//private String text;
		private List<String> quick_replies;
		private List<UrlArray> urlArray;

		//		public String getText() {
//			return text;
//		}
//		public void setText(String text) {
//			this.text = text;
//		}
		public List<String> getQuick_replies() {
			return quick_replies;
		}
		public void setQuick_replies(List<String> quick_replies) {
			this.quick_replies = quick_replies;
		}
		public List<UrlArray> getUrlArray() {
			return urlArray;
		}
		public void setUrlArray(List<UrlArray> urlArray) {
			this.urlArray = urlArray;
		}
}
