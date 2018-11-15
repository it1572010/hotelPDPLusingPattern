package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class Role {

    private int idRole;
    private String namaRole;

    public Role() {
    }

    public Role(int idRole, String namaRole) {
        this.idRole = idRole;
        this.namaRole = namaRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

}
