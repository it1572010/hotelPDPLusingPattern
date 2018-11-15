/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

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
public class GuestDaoImpl implements DaoService<Guest> {

    @Override
    public int addData(Guest object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO guest(firstName,lastName,alamatTamu,noHandPhone,member_idMember) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getFirstName());
                ps.setString(2, object.getLastName());
                ps.setString(3, object.getAlamatTamu());
                ps.setString(4, object.getNoHandphone());
                ps.setInt(5, object.getMember().getIdMember());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuestDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Guest object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "UPDATE guest SET firstName=?,lastName=?,alamatTamu=?,noHandPhone=?,member_idMember=? WHERE idGuest=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getFirstName());
                ps.setString(2, object.getLastName());
                ps.setString(3, object.getAlamatTamu());
                ps.setString(4, object.getNoHandphone());
                ps.setInt(5, object.getMember().getIdMember());
                ps.setInt(6, object.getIdGuest());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuestDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Guest object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM guest WHERE idGuest=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getIdGuest());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuestDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Guest> showAllData() {
        List<Guest> guests = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT g.*,m.* FROM guest g JOIN member m ON g.member_idMember = m.idMember";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Guest guest = new Guest();
                    guest.setIdGuest(rs.getInt("idGuest"));
                    guest.setAlamatTamu(rs.getString("alamatTamu"));
                    guest.setFirstName(rs.getString("firstName"));
                    guest.setLastName(rs.getString("lastName"));
                    guest.setNoHandphone(rs.getString("noHandphone"));

                    Member member = new Member(rs.getInt("member_idMember"), rs.
                            getString("tipeMember"));
                    guest.setMember(member);

                    guests.add(guest);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return guests;
    }

}
