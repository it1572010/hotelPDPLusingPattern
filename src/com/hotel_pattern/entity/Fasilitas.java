package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class Fasilitas {

    private int idFasilitas;
    private String namaFasilitas;
    private int hargaFasilitas;

    public Fasilitas() {
    }

    public Fasilitas(int idFasilitas, String namaFasilitas, int hargaFasilitas) {
        this.idFasilitas = idFasilitas;
        this.namaFasilitas = namaFasilitas;
        this.hargaFasilitas = hargaFasilitas;
    }

    public int getIdFasilitas() {
        return idFasilitas;
    }

    public void setIdFasilitas(int idFasilitas) {
        this.idFasilitas = idFasilitas;
    }

    public String getNamaFasilitas() {
        return namaFasilitas;
    }

    public void setNamaFasilitas(String namaFasilitas) {
        this.namaFasilitas = namaFasilitas;
    }

    public int getHargaFasilitas() {
        return hargaFasilitas;
    }

    public void setHargaFasilitas(int hargaFasilitas) {
        this.hargaFasilitas = hargaFasilitas;
    }

}
