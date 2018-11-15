/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.dao;

import com.hotel_pattern.entity.Employees;
import com.hotel_pattern.entity.Hotel;
import com.hotel_pattern.entity.Role;
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
public class EmployeesDaoImpl implements DaoService<Employees> {

    @Override
    public int addData(Employees object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "INSERT INTO employees(employee_id, noKTP,namaEmployee,alamatEmployee,jenisKelamin,Role_idRole,hotel_idHotel) VALUES(?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getEmployee_id());
                ps.setString(2, object.getNoKTP());
                ps.setString(3, object.getNamaEmployee());
                ps.setString(4, object.getAlamatEmployee());
                ps.setString(5, object.getJenisKelamin());
                ps.setInt(6, object.getRole().getIdRole());
                ps.setInt(7, object.getHotel().getIdHotel());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Employees object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "Update employees SET noKTP=?,namaEmployee=?,alamatEmployee=?,jenisKelamin=?,Role_idRole=? WHERE employee_id=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(6, object.getEmployee_id());
                ps.setString(1, object.getNoKTP());
                ps.setString(2, object.getNamaEmployee());
                ps.setString(3, object.getAlamatEmployee());
                ps.setString(4, object.getJenisKelamin());
                ps.setInt(5, object.getRole().getIdRole());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Employees object) {
        int result = 0;
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "DELETE FROM employees WHERE employee_id=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getEmployee_id());

                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Employees> showAllData() {
        List<Employees> employeeses = new ArrayList<>();
        try {
            Connection connection = Koneksi.createConnection();
            String query
                    = "SELECT e.*,r.namaRole, h.namaHotel, h.alamatHotel FROM employees e JOIN ROLE r ON e.Role_idRole = r.idRole JOIN hotel h ON h.idHotel = e.hotel_idHotel ORDER BY employee_id";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employees employees = new Employees();
                    employees.setEmployee_id(rs.getString("employee_id"));
                    employees.setAlamatEmployee(rs.getString("alamatEmployee"));
                    employees.setJenisKelamin(rs.getString("jenisKelamin"));
                    employees.setNamaEmployee(rs.getString("namaEmployee"));
                    employees.setNoKTP(rs.getString("noKTP"));
                    Hotel hotel = new Hotel(rs.getInt("hotel_idHotel"), rs.
                            getString("namaHotel"), rs.getString("alamatHotel"));
                    Role role = new Role(rs.getInt("Role_idRole"), rs.getString(
                            "namaRole"));
                    employees.setHotel(hotel);
                    employees.setRole(role);
                    employeeses.add(employees);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return employeeses;
    }

}
