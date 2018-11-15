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
public class aDayBefore implements iStrategy {

    @Override
    public int doPrice(int price) {
        int result = 0;
        result = price + (price / 4);
        return result;
    }

}
