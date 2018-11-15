/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

import com.hotel_pattern.entity.Fasilitas;
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
public class FasilitasDaoImpl implements DaoService<Fasilitas> {

    @Override
    public int addData(Fasilitas object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO fasilitas( namaFasilitas,hargaFasilitas) VALUES(?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getNamaFasilitas());
                ps.setInt(2, object.getHargaFasilitas());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(FasilitasDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Fasilitas object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "UPDATE fasilitas SET namaFasilitas=?,hargaFasilitas=? WHERE idFasilitas=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(3, object.getIdFasilitas());
                ps.setString(1, object.getNamaFasilitas());
                ps.setInt(2, object.getHargaFasilitas());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(FasilitasDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Fasilitas object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM fasilitas WHERE idFasilitas=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getIdFasilitas());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(FasilitasDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Fasilitas> showAllData() {
        List<Fasilitas> fasilitases = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query = "SELECT * FROM fasilitas ORDER BY idFasilitas";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Fasilitas fasilitas = new Fasilitas();
                    fasilitas.setIdFasilitas(rs.getInt("idFasilitas"));
                    fasilitas.setNamaFasilitas(rs.getString("namaFasilitas"));
                    fasilitas.setHargaFasilitas(rs.getInt("hargaFasilitas"));
                    fasilitases.add(fasilitas);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return fasilitases;
    }

}
