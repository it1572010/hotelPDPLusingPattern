/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.pattern.singleton;

import com.hotel_pattern.entity.Room;
import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class roomList {

    static ArrayList<Room> rooms;
//    private Room room;

    private roomList() {
        rooms = new ArrayList();
    }

    public static ArrayList<Room> getInstance() {
        if (rooms == null) {
            new roomList();
        } else {
            return rooms;
        }
        return null;
    }

}
