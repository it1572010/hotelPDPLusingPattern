package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class FasilitasHasGuest {

    private Fasilitas fasilitas;
    private Guest guest;

    public FasilitasHasGuest() {
    }

    public FasilitasHasGuest(Fasilitas fasilitas, Guest guest) {
        this.fasilitas = fasilitas;
        this.guest = guest;
    }

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(Fasilitas fasilitas) {
        this.fasilitas = fasilitas;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

}
