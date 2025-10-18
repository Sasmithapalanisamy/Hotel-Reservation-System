package com.hotel.dao;
import com.hotel.model.Room;
import com.hotel.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Room r = new Room();
                r.setRoomId(rs.getInt("room_id"));
                r.setRoomNumber(rs.getString("room_number"));
                r.setType(rs.getString("type"));
                r.setPrice(rs.getDouble("price"));
                r.setCapacity(rs.getInt("capacity"));
                r.setStatus(rs.getString("status"));
                r.setDescription(rs.getString("description"));
                list.add(r);
            }
        } catch(SQLException e) { e.printStackTrace(); }
        return list;
    }

    public Room findById(int roomId){
        String sql="SELECT * FROM rooms WHERE room_id=?";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Room r=new Room();
                r.setRoomId(rs.getInt("room_id"));
                r.setRoomNumber(rs.getString("room_number"));
                r.setType(rs.getString("type"));
                r.setPrice(rs.getDouble("price"));
                r.setCapacity(rs.getInt("capacity"));
                r.setStatus(rs.getString("status"));
                r.setDescription(rs.getString("description"));
                return r;
            }
        } catch(SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void updateRoomStatus(int roomId, String status) {
        String sql = "UPDATE rooms SET status=? WHERE room_id=?";
        try(Connection con=DBUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, roomId);
            ps.executeUpdate();
        }catch(SQLException e){e.printStackTrace();}
    }
}
