package com.hotel.model;
import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int userId;
    private int roomId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String status;
    private double totalAmount;
    // constructors, getters, setters...
 // Default constructor
    public Booking() {}

    // Parameterized constructor
    public Booking(int bookingId, int userId, int roomId, LocalDate checkinDate, LocalDate checkoutDate, String status, double totalAmount) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
