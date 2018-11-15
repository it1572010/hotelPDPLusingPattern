package com.hotel_pattern.pattern.strategy;

import com.hotel_pattern.dao.DeluxeRoomDaoImpl;
import com.hotel_pattern.dao.StandartRoomDaoImpl;
import com.hotel_pattern.entity.Reservation;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Anthony
 */
public class strategyContext {

    private iStrategy strategy;

    public int executeStrategy(Reservation reservation) {
        int result = 0;
        LocalDate pesen = LocalDate.parse(reservation.getTglPesan().
                toString().substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate masuk = LocalDate.parse(reservation.getTglMasuk().
                toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(pesen.atStartOfDay(), masuk.
                atStartOfDay());
        long diffDays = diff.toDays();
        ////////////////////////get Price ROOM///////////////////////
        int harga = 0;
        if (reservation.getRoom().getNoKamar().substring(0, 1).
                toLowerCase().equals("d")) {
            DeluxeRoomDaoImpl dao = new DeluxeRoomDaoImpl();
            harga = dao.getOnePrice(reservation.getRoom().getNoKamar());
        } else {
            StandartRoomDaoImpl dao = new StandartRoomDaoImpl();
            harga = dao.getOnePrice(reservation.getRoom().getNoKamar());
        }
        /////////////////////////////////////////////////////////////
        //////////////////////////CEK DIFFDAYS///////////////////////
        if (diffDays <= 1) {
            strategy = new aDayBefore();
            result = strategy.doPrice(harga);
        } else if (diffDays <= 7) {
            strategy = new aWeekBefore();
            result = strategy.doPrice(harga);
        } else {
            strategy = new aMonthBefore();
            result = strategy.doPrice(harga);
        }
        LocalDate keluar = LocalDate.parse(reservation.getTglKeluar().
                toString().substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE);

        Duration hariInap = Duration.between(masuk.atStartOfDay(), keluar.
                atStartOfDay());
        long hariInaps = hariInap.toDays();
        result = result * ((int) hariInaps);
        /////////////////////////////////////////////////////////////
        return result;
    }
}
