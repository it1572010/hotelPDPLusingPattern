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
public class Hotel {

    private int idHotel;
    private String namaHotel;
    private String alamatHotel;

    public Hotel() {
    }

    public Hotel(int idHotel, String namaHotel, String alamatHotel) {
        this.idHotel = idHotel;
        this.namaHotel = namaHotel;
        this.alamatHotel = alamatHotel;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getAlamatHotel() {
        return alamatHotel;
    }

    public void setAlamatHotel(String alamatHotel) {
        this.alamatHotel = alamatHotel;
    }

}
