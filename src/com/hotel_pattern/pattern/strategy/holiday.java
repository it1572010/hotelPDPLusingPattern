/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.pattern.strategy;

/**
 *
 * @author Anthony
 */
public class holiday implements iStrategy {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int doPrice(int price) {
        int result = 0;
        result = price - (price * (getDiscount() / 100));
        return result;
    }

}
