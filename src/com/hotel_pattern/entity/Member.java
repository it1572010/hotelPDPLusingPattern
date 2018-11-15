package com.hotel_pattern.entity;

/**
 *
 * @author Anthony
 */
public class Member {

    private int idMember;
    private String tipeMember;

    public Member() {
    }

    public Member(int idMember, String tipeMember) {
        this.idMember = idMember;
        this.tipeMember = tipeMember;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getTipeMember() {
        return tipeMember;
    }

    public void setTipeMember(String tipeMember) {
        this.tipeMember = tipeMember;
    }

}
