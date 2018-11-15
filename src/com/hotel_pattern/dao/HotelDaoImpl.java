package com.hotel_pattern.dao;

import com.hotel_pattern.entity.Hotel;
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
public class HotelDaoImpl implements DaoService<Hotel> {

    @Override
    public int addData(Hotel object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO hotel(namaHotel,alamatHotel) VALUES(?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaHotel());
                ps.setString(2, object.getAlamatHotel());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(HotelDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Hotel object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "UPDATE hotel SET namaHotel=?,alamatHotel=? WHERE idHotel=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaHotel());
                ps.setString(2, object.getAlamatHotel());
                ps.setInt(3, object.getIdHotel());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(HotelDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Hotel object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM hotel WHERE idHotel=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getIdHotel());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(HotelDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Hotel> showAllData() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT * FROM hotel";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setIdHotel(rs.getInt("idHotel"));
                    hotel.setNamaHotel(rs.getString("namaHotel"));
                    hotel.setAlamatHotel(rs.getString("alamatHotel"));
                    hotels.add(hotel);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return hotels;
    }

}
