package com.hotel.dao;
import com.hotel.model.Booking;
import com.hotel.util.DBUtil;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    // Check overlapping bookings for the room
    public boolean isRoomAvailable(int roomId, LocalDate checkin, LocalDate checkout) {
        String sql = "SELECT * FROM bookings WHERE room_id=? AND status <> 'Cancelled' AND ( (checkin_date <= ? AND checkout_date > ?) OR (checkin_date < ? AND checkout_date >= ?) OR (checkin_date >= ? AND checkout_date <= ?) )";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            // use dates
            Date ci = Date.valueOf(checkin);
            Date co = Date.valueOf(checkout);
            ps.setDate(2, ci);
            ps.setDate(3, ci);
            ps.setDate(4, co);
            ps.setDate(5, co);
            ps.setDate(6, ci);
            ps.setDate(7, co);
            ResultSet rs = ps.executeQuery();
            return !rs.next(); // true if no overlapping
        } catch(SQLException e){ e.printStackTrace(); }
        return false;
    }

    public boolean createBooking(Booking b) {
        String sql = "INSERT INTO bookings(user_id, room_id, checkin_date, checkout_date, status, total_amount) VALUES(?,?,?,?,?,?)";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, b.getUserId());
            ps.setInt(2, b.getRoomId());
            ps.setDate(3, Date.valueOf(b.getCheckinDate()));
            ps.setDate(4, Date.valueOf(b.getCheckoutDate()));
            ps.setString(5, b.getStatus());
            ps.setDouble(6, b.getTotalAmount());
            return ps.executeUpdate()>0;
        } catch(SQLException e){ e.printStackTrace(); return false;}
    }

    public List<Booking> getBookingsByUser(int userId){
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE user_id=?";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Booking b = new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                b.setUserId(rs.getInt("user_id"));
                b.setRoomId(rs.getInt("room_id"));
                b.setCheckinDate(rs.getDate("checkin_date").toLocalDate());
                b.setCheckoutDate(rs.getDate("checkout_date").toLocalDate());
                b.setStatus(rs.getString("status"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                list.add(b);
            }
        } catch(SQLException e){ e.printStackTrace();}
        return list;
    }

    public List<Booking> getAllBookings(){
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings ORDER BY created_at DESC";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                Booking b=new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                b.setUserId(rs.getInt("user_id"));
                b.setRoomId(rs.getInt("room_id"));
                b.setCheckinDate(rs.getDate("checkin_date").toLocalDate());
                b.setCheckoutDate(rs.getDate("checkout_date").toLocalDate());
                b.setStatus(rs.getString("status"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                list.add(b);
            }
        } catch(SQLException e){ e.printStackTrace(); }
        return list;
    }

    public void cancelBooking(int bookingId) {
        String sql = "UPDATE bookings SET status='Cancelled' WHERE booking_id=?";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, bookingId);
            ps.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
    }
}
