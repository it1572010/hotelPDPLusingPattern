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
public class MemberFactory {

    public iMember getMember(int member) {
        if (member == 2) {
            return new Gold();
        } else if (member == 1) {
            return new Silver();
        } else {
            return new NonMember();
        }
    }

}
