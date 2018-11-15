package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class Guest {

    private int idGuest;
    private String firstName;
    private String lastName;
    private String alamatTamu;
    private String noHandphone;
    private Member member;

    public Guest() {
    }

    public Guest(int idGuest, String firstName, String lastName,
            String alamatTamu, String noHandphone, Member member) {
        this.idGuest = idGuest;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alamatTamu = alamatTamu;
        this.noHandphone = noHandphone;
        this.member = member;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlamatTamu() {
        return alamatTamu;
    }

    public void setAlamatTamu(String alamatTamu) {
        this.alamatTamu = alamatTamu;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
