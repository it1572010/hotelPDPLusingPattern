/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class Employees {

    private String employee_id;
    private String noKTP;
    private String namaEmployee;
    private String alamatEmployee;
    private String jenisKelamin;
    private Role role;
    private Hotel hotel;

    public Employees() {
    }

    public Employees(String employee_id, String noKTP, String namaEmployee,
            String alamatEmployee, String jenisKelamin, Role role, Hotel hotel) {
        this.employee_id = employee_id;
        this.noKTP = noKTP;
        this.namaEmployee = namaEmployee;
        this.alamatEmployee = alamatEmployee;
        this.jenisKelamin = jenisKelamin;
        this.role = role;
        this.hotel = hotel;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public String getNamaEmployee() {
        return namaEmployee;
    }

    public void setNamaEmployee(String namaEmployee) {
        this.namaEmployee = namaEmployee;
    }

    public String getAlamatEmployee() {
        return alamatEmployee;
    }

    public void setAlamatEmployee(String alamatEmployee) {
        this.alamatEmployee = alamatEmployee;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
