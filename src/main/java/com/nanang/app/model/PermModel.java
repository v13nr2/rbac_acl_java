package com.nanang.app.model;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PermModel {

	     private String id;
	    @JsonProperty("aauth_perms")
	    private String aauthPerms;
	    private String definition;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getAauthPerms() {
			return aauthPerms;
		}
		public void setAauthPerms(String aauthPerms) {
			this.aauthPerms = aauthPerms;
		}
		public String getDefinition() {
			return definition;
		}
		public void setDefinition(String definition) {
			this.definition = definition;
		}
	    
	    
}
