package com.example.bravenewcoin.components;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenBody {

	@SerializedName("audience")
	@Expose
	private String audience = "https://api.bravenewcoin.com";
	@SerializedName("client_id")
	@Expose
	private String clientId = "oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY";
	@SerializedName("grant_type")
	@Expose
	private String grantType = "client_credentials";

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
}