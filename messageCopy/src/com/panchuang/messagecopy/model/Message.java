package com.panchuang.messagecopy.model;

public class Message {
	private String body;
	private String data;
	private String address;
	private String type;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Message(String body, String data, String address, String type) {
		super();
		this.body = body;
		this.data = data;
		this.address = address;
		this.type = type;
	}
	
	
}
