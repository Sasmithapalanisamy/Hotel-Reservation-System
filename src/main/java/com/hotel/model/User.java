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
}
