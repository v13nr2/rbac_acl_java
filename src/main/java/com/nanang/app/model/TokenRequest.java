package com.nanang.app.model;

public class TokenRequest {

	private String clientId;
	private String secret;
	
	
	
	public TokenRequest(String clientId, String secret) {
		super();
		this.clientId = clientId;
		this.secret = secret;
	}
	public TokenRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	
}
