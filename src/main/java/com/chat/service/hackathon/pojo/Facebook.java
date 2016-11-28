package com.chat.service.hackathon.pojo;

import java.util.Map;

public class Facebook {
		private Map<String,String> recipient;
		private Map<String,String> message;
		private String sender_action;
		private String notification_type;
		public Map<String, String> getRecipient() {
			return recipient;
		}
		public void setRecipient(Map<String, String> recipient) {
			this.recipient = recipient;
		}
		public Map<String, String> getMessage() {
			return message;
		}
		public void setMessage(Map<String, String> message) {
			this.message = message;
		}
		public String getSender_action() {
			return sender_action;
		}
		public void setSender_action(String sender_action) {
			this.sender_action = sender_action;
		}
		public String getNotification_type() {
			return notification_type;
		}
		public void setNotification_type(String notification_type) {
			this.notification_type = notification_type;
		}
}
