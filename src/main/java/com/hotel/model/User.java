package com.hotel.model;
import java.time.LocalDateTime;

public class User {
    private int userId;
    private String name, email, password, role;
    private LocalDateTime createdAt;

    public User() {}
    public User(String name, String email, String password, String role){
        this.name=name; this.email=email; this.password=password; this.role=role;
    }
    // getters and setters...
    // (implement all standard getters/setters)
    public void setName(String name) {
    	this.name=name;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public void setPassword(String pass) {
    	this.password=pass;
    }
    public void setRole(String role) {
    	this.role=role;
    }
    public void setUserId(int u) {
    	this.userId=u;
    }
    public String getName() {
    	return name;
    }
    public String getEmail() {
    	return email;
    }
    public String getPassword() {
    	return password;
    }
    public String getRole() {
    	return role;
    }
    public int getUserId() {
    	return userId;
    }
}
