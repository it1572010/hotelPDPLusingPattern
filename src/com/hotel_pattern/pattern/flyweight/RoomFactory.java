package com.hotel_pattern.pattern.flyweight;

import static com.hotel_pattern.MainApp.getDeluxeRoomDaoImpl;
import static com.hotel_pattern.MainApp.getDeluxeRooms;
import static com.hotel_pattern.MainApp.getStandardRooms;
import static com.hotel_pattern.MainApp.getStandartRoomDaoImpl;
import com.hotel_pattern.entity.DeluxeRoom;
import com.hotel_pattern.entity.StandardRoom;

/**
 *
 * @author Anthony
 */
public class RoomFactory {

    private static DeluxeRoom delRoom = new DeluxeRoom();
    private static StandardRoom staRoom = new StandardRoom();

    public void separateRoom(String noKamar, int hargaKamar) {
        if (noKamar.substring(0, 1).equals("D")) {
            delRoom.setHargaKamar(hargaKamar);
            delRoom.setNoKamar(noKamar);
            delRoom.setStatusKamar("Available");
            delRoom.setTipeKamar("Deluxe");
            getDeluxeRoomDaoImpl().addData(delRoom);
            getDeluxeRooms().clear();
            getDeluxeRooms().addAll(getDeluxeRoomDaoImpl().
                    showAllData());
        } else {
            staRoom.setHargaKamar(hargaKamar);
            staRoom.setNoKamar(noKamar);
            staRoom.setStatusKamar("Available");
            staRoom.setTipeKamar("Standard");
            getStandartRoomDaoImpl().addData(staRoom);
            getStandardRooms().clear();
            getStandardRooms().addAll(getStandartRoomDaoImpl().
                    showAllData());
        }
    }
}
