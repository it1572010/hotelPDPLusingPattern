/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

import com.hotel_pattern.entity.Fasilitas;
import com.hotel_pattern.entity.FasilitasHasGuest;
import com.hotel_pattern.entity.Guest;
import com.hotel_pattern.entity.Member;
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
public class FasilitasHasGuestDaoImpl implements DaoService<FasilitasHasGuest> {

    @Override
    public int addData(FasilitasHasGuest object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO fasilitas_has_guest(fasilitas_idFasilitas, guest_idguest) VALUES(?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getFasilitas().getIdFasilitas());
                ps.setInt(2, object.getGuest().getIdGuest());
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
    public int updateData(FasilitasHasGuest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(FasilitasHasGuest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FasilitasHasGuest> showAllData() {
        List<FasilitasHasGuest> fasilitasHasGuests = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT fg.* ,f.*,g.*,m.* FROM fasilitas_has_guest fg JOIN fasilitas f ON f.idFasilitas = fg.fasilitas_idFasilitas JOIN guest g ON fg.guest_idguest = g.idGuest JOIN member m ON g.member_idMember = m.idMember";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FasilitasHasGuest fasilitasHasGuest
                            = new FasilitasHasGuest();

                    Member member = new Member(rs.getInt("idMember"), rs.
                            getString("tipeMember"));

                    Fasilitas fasilitas
                            = new Fasilitas(rs.getInt("idFasilitas"), rs.
                                    getString("namaFasilitas"), rs.getInt(
                                    "hargaFasilitas"));

                    Guest guest = new Guest(rs.getInt("idGuest"), rs.getString(
                            "firstName"), rs.getString("lastName"), rs.
                            getString("alamatTamu"), rs.getString(
                            "noHandphone"),
                            member);

                    fasilitasHasGuest.setFasilitas(fasilitas);
                    fasilitasHasGuest.setGuest(guest);
                    fasilitasHasGuests.add(fasilitasHasGuest);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return fasilitasHasGuests;
    }

}
