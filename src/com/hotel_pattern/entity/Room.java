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
public class Room {

    private String noKamar;
    private int hargaKamar;
    private String tipeKamar;
    private String statusKamar;

    public Room() {
    }

    public Room(String noKamar, int hargaKamar, String tipeKamar,
            String statusKamar) {
        this.noKamar = noKamar;
        this.hargaKamar = hargaKamar;
        this.tipeKamar = tipeKamar;
        this.statusKamar = statusKamar;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public int getHargaKamar() {
        return hargaKamar;
    }

    public void setHargaKamar(int hargaKamar) {
        this.hargaKamar = hargaKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getStatusKamar() {
        return statusKamar;
    }

    public void setStatusKamar(String statusKamar) {
        this.statusKamar = statusKamar;
    }

}
