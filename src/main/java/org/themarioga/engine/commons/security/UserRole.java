package org.themarioga.engine.commons.security;

public enum UserRole {
	ADMIN("admin"),
	USER("user");

	private final String role;

	UserRole(String role) {
		this.role = role;
	}

	public String getValue() {
		return role;
	}
}