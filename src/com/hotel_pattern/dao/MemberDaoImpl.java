/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

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
public class MemberDaoImpl implements DaoService<Member> {

    @Override
    public int addData(Member object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO member(tipeMember) VALUES(?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getTipeMember());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Member object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "UPDATE member SET tipeMember=? WHERE idMember=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getTipeMember());
                ps.setInt(2, object.getIdMember());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Member object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM member WHERE idMember=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getIdMember());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MemberDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Member> showAllData() {
        List<Member> members = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT * FROM member";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Member member = new Member();
                    member.setIdMember(rs.getInt("idMember"));
                    member.setTipeMember(rs.getString("tipeMember"));
                    members.add(member);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
        return members;
    }

}
