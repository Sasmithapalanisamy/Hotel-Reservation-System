package com.hotel.model;

public class Room {
    private int roomId;
    private String roomNumber, type, status, description;
    private double price;
    private int capacity;

    public Room() {}
    // getters and setters...
    public void setRoomId(int id) {this.roomId=id;}
    public void setRoomNumber(String rno) {
    	this.roomNumber=rno;
    }
    public void setType(String t) {
    	this.type=t;
    }
    public void setStatus(String s) {
    	this.status=s;
    }
    public void setDescription(String d) {
    	this.description=d;
    }
    public void setPrice(double p) {
    	this.price=p;
    }
    public void setCapacity(int c) {
    	this.capacity=c;
    }
    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }
}
