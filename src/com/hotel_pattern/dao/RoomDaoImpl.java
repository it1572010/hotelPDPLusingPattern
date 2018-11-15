/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

import com.hotel_pattern.entity.Room;
import com.hotel_pattern.utility.DaoService;
import com.hotel_pattern.utility.Koneksi;
import com.hotel_pattern.utility.ViewUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Anthony
 */
public class RoomDaoImpl implements DaoService<Room> {

    @Override
    public int addData(Room object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO room(noKamar, hargaKamar, tipeKamar, statusKamar) VALUES(?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNoKamar());
                ps.setInt(2, object.getHargaKamar());
                ps.setString(3, object.getTipeKamar());
                ps.setString(4, object.getStatusKamar());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RoomDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Room object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "UPDATE room SET hargaKamar=?,tipeKamar=?, statusKamar=? WHERE noKamar=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getHargaKamar());
                ps.setString(2, object.getTipeKamar());
                ps.setString(3, object.getStatusKamar());
                ps.setString(4, object.getNoKamar());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RoomDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Room object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM room WHERE noKamar=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNoKamar());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RoomDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Room> showAllData() {
        List<Room> rooms = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT * FROM room";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Room room = new Room();
                    room.setNoKamar(rs.getString("noKamar"));
                    room.setHargaKamar(rs.getInt("hargaKamar"));
                    room.setTipeKamar(rs.getString("tipeKamar"));
                    room.setStatusKamar(rs.getString("statusKamar"));
                    rooms.add(room);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return rooms;
    }

}
