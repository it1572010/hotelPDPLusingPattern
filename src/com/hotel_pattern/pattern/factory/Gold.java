/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.pattern.factory;

/**
 *
 * @author Anthony
 */
public class Gold implements iMember {

    @Override
    public int setPromo(int price) {
        return price - (price / 9);
    }

}
