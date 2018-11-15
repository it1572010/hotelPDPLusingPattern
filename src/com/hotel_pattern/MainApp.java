package com.hotel_pattern;

import com.hotel_pattern.dao.DeluxeRoomDaoImpl;
import com.hotel_pattern.dao.GuestDaoImpl;
import com.hotel_pattern.dao.MemberDaoImpl;
import com.hotel_pattern.dao.ReservationDaoImpl;
import com.hotel_pattern.dao.RoomDaoImpl;
import com.hotel_pattern.dao.StandartRoomDaoImpl;
import com.hotel_pattern.entity.DeluxeRoom;
import com.hotel_pattern.entity.Guest;
import com.hotel_pattern.entity.Member;
import com.hotel_pattern.entity.Reservation;
import com.hotel_pattern.entity.Room;
import com.hotel_pattern.entity.StandardRoom;
import com.hotel_pattern.pattern.adapter.GuestAdapter;
import com.hotel_pattern.pattern.factory.MemberFactory;
import com.hotel_pattern.pattern.factory.iMember;
import com.hotel_pattern.pattern.flyweight.RoomFactory;
import com.hotel_pattern.pattern.singleton.roomList;
import com.hotel_pattern.pattern.strategy.strategyContext;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anthony
 */
public class MainApp {

    public static List<Reservation> reservations;
    public static ReservationDaoImpl reservationDaoImpl;
    public static List<DeluxeRoom> deluxeRooms;
    public static DeluxeRoomDaoImpl deluxeRoomDaoImpl;
    public static List<StandardRoom> standardRooms;
    public static StandartRoomDaoImpl standartRoomDaoImpl;
    public static MemberDaoImpl memberDaoImpl;
    public static List<Member> members;
    public static GuestDaoImpl guestDaoImpl;
    public static List<Guest> guests;
    public static RoomDaoImpl roomDaoImpl;
    private static List<Room> rooms = (List<Room>) roomList.getInstance();

    public static ReservationDaoImpl getReservationDaoImpl() {
        if (reservationDaoImpl == null) {
            reservationDaoImpl = new ReservationDaoImpl();
        }
        return reservationDaoImpl;
    }

    public static List<Reservation> getReservations() {
        List<Reservation> result = getReservationDaoImpl().showAllData();
        return result;
    }

    public static MemberDaoImpl getMemberDaoImpl() {
        if (memberDaoImpl == null) {
            memberDaoImpl = new MemberDaoImpl();
        }
        return memberDaoImpl;
    }

    public static List<Member> getMembers() {
        List<Member> result = getMemberDaoImpl().showAllData();
        return result;
    }

    public static GuestDaoImpl getGuestDaoImpl() {
        if (guestDaoImpl == null) {
            guestDaoImpl = new GuestDaoImpl();
        }
        return guestDaoImpl;
    }

    public static List<Guest> getGuests() {
        List<Guest> result = getGuestDaoImpl().showAllData();
        return result;
    }

    public static DeluxeRoomDaoImpl getDeluxeRoomDaoImpl() {
        if (deluxeRoomDaoImpl == null) {
            deluxeRoomDaoImpl = new DeluxeRoomDaoImpl();
        }
        return deluxeRoomDaoImpl;
    }

    public static List<DeluxeRoom> getDeluxeRooms() {
        List<DeluxeRoom> result = getDeluxeRoomDaoImpl().showAllData();
        return result;
    }

    public static StandartRoomDaoImpl getStandartRoomDaoImpl() {
        if (standartRoomDaoImpl == null) {
            standartRoomDaoImpl = new StandartRoomDaoImpl();
        }
        return standartRoomDaoImpl;
    }

    public static List<StandardRoom> getStandardRooms() {
        List<StandardRoom> result = getStandartRoomDaoImpl().showAllData();
        return result;
    }

    public static RoomDaoImpl getRoomDaoImpl() {
        if (roomDaoImpl == null) {
            roomDaoImpl = new RoomDaoImpl();
        }
        return roomDaoImpl;
    }

    public static List<Room> getRooms() {
        rooms = getRoomDaoImpl().showAllData();
        return rooms;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Menggunakan Pattern Strategy
        reservations = getReservations();
        for (Reservation x : reservations) {
            System.out.println(x.getIdReservation()
                    + ". Tanggal masuk : " + x.
                            getTglMasuk()
                    + " - Tanggal keluar : " + x.getTglKeluar()
                    + " - Hotel : " + x.getHotel().
                            getNamaHotel()
                    + " - Room : " + x.getRoom().getNoKamar()
                    + " - Guest : " + x.getGuest().
                            getFirstName() + " " + x.getGuest().
                            getLastName());
            strategyContext c = new strategyContext();
            int r = c.executeStrategy(x);
            System.out.println("Harga Total Setelah DoPrice(Strategy) : " + r);
        }

        ///Menggunakan Pattern singleton
        slightPause();
        rooms = getRooms();
        for (Room x : rooms) {
            System.out.println("No Kamar : " + x.getNoKamar()
                    + " - Tipe : " + x.getTipeKamar()
                    + " - Status : " + x.getStatusKamar()
                    + " - Harga : " + x.getHargaKamar());
        }
        //Menggunakan Pattern Adapter
        slightPause();
        System.out.print("Masukkan nama lengkap : ");
        String namaLengkap = s.nextLine();
        System.out.print("Masukkan alamat : ");
        String alamat = s.nextLine();
        System.out.print("No Handphone : ");
        String noHandphone = s.next();
        members = getMembers();
        for (Member x : members) {
            System.out.println(x.getIdMember() + " - " + x.
                    getTipeMember());
        }
        System.out.print("Tipe Member : ");
        int tipeMember = s.nextInt();
        GuestAdapter guest = new GuestAdapter();
        Member member = new Member();
        member.setIdMember(tipeMember);
        guest.guestAdapter(namaLengkap, alamat, noHandphone, member);
//        getGuestDaoImpl().addData(guest);
        getGuests().clear();
        getGuests().addAll(getGuestDaoImpl().showAllData());

        //Menggunakan Pattern Factory
        slightPause();
        System.out.print("No HP : ");
        String noHp = s.next();
        reservations = getReservations();
        for (Reservation x : reservations) {
            if (x.getGuest().getNoHandphone().equals(noHp)) {
                strategyContext c = new strategyContext();
                int r = c.executeStrategy(x);
                iMember m = new MemberFactory().getMember(x.getGuest().
                        getMember().getIdMember());

                System.out.println("Harga Total Setelah Discount : "
                        + m.setPromo(r));
            }
        }

        //Menggunakan Flyweight Pattern
        slightPause();
        System.out.print("No Kamar : ");
        String noKamar = s.next();
        System.out.print("Harga Kamar : ");
        int hargaKamar = s.nextInt();
        RoomFactory r = new RoomFactory();
        r.separateRoom(noKamar, hargaKamar);

    }

    public static void slightPause() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nPress enter to Continue...");
        s.nextLine();
    }
}
