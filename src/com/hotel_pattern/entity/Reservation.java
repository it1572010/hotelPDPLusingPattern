package com.hotel_pattern.entity;

import java.util.Date;

/**
 *
 * @author Anthony
 */
public class Reservation {

    private int idReservation;
    private Date tglMasuk;
    private Date tglKeluar;
    private Date tglPesan;
    private Hotel hotel;
    private Room room;
    private Guest guest;

    public Reservation() {
    }

    public Reservation(int idReservation, Date tglMasuk, Date tglKeluar,
            Date tglPesan, Hotel hotel, Room room, Guest guest) {
        this.idReservation = idReservation;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
        this.tglPesan = tglPesan;
        this.hotel = hotel;
        this.room = room;
        this.guest = guest;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Date getTglKeluar() {
        return tglKeluar;
    }

    public void setTglKeluar(Date tglKeluar) {
        this.tglKeluar = tglKeluar;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getTglPesan() {
        return tglPesan;
    }

    public void setTglPesan(Date tglPesan) {
        this.tglPesan = tglPesan;
    }

}
