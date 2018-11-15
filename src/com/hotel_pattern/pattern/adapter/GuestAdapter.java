/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.pattern.adapter;

import static com.hotel_pattern.MainApp.guestDaoImpl;
import com.hotel_pattern.dao.GuestDaoImpl;
import com.hotel_pattern.entity.Guest;
import com.hotel_pattern.entity.Member;

/**
 *
 * @author Anthony
 */
public class GuestAdapter {

    public static GuestDaoImpl getGuestDaoImpl() {
        if (guestDaoImpl == null) {
            guestDaoImpl = new GuestDaoImpl();
        }
        return guestDaoImpl;
    }

    public Guest guestAdapter(String fullName, String address,
            String phoneNumber, Member member) {
        String[] arrName = fullName.split(" ");
        String firstName = "";

        for (int i = 0; i < arrName.length - 1; i++) {
            firstName += arrName[i] + " ";
        }

        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(arrName[arrName.length - 1]);
        guest.setAlamatTamu(address);
        guest.setNoHandphone(phoneNumber);
        guest.setMember(member);
        getGuestDaoImpl().addData(guest);
        return guest;
    }
}
