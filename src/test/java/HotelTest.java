import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Guest guest1;
    private Guest guest2;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private ConferenceRoom cRoom;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> cRooms;
    private ArrayList<Guest> uncheckedGuests1;
    private ArrayList<Guest> uncheckedGuests2;
    private Hotel cct;
    private Booking booking;
    private DiningRoom laChambre;
    private DiningRoom laCuisine;
    private DiningRoom laSalleAManger;
    private HashMap<String, DiningRoom> diningRooms;


    @Before
    public void before(){
        guest1 = new Guest("Jesse");
        guest2 = new Guest("James");
        uncheckedGuests1 = new ArrayList<>();
        uncheckedGuests1.add(guest1);
        uncheckedGuests2 = new ArrayList<>();
        uncheckedGuests2.add(guest2);
        bedroom1 = new Bedroom(1, RoomType.SINGLE, 7, 45.00 );
        bedroom2 = new Bedroom(1, RoomType.SINGLE, 8, 40.00 );
        cRoom = new ConferenceRoom(50, "Orkney");
        bedrooms = new ArrayList<>();
        cRooms = new ArrayList<>();
        cRooms.add(cRoom);
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        laChambre = new DiningRoom("La Chambre", 20);
        laSalleAManger = new DiningRoom("La Salle a Manger", 50);
        laCuisine = new DiningRoom("La Cuisine", 15);
        diningRooms = new HashMap<>();
        diningRooms.put("La Chambre", laChambre);
        diningRooms.put("La Salle a Manger", laSalleAManger);
        diningRooms.put("La Cuisine", laCuisine);
        cct = new Hotel(bedrooms, cRooms, diningRooms);
        booking = new Booking(bedroom1, 5);
    }

    @Test
    public void canGetRoomOfType() {
        assertEquals(cct.getRoomOfType(RoomType.SINGLE), bedroom1);
    }

    @Test
    public void canCheckInSingle(){
    cct.checkIn(uncheckedGuests1, RoomType.SINGLE );
    assertEquals(bedroom1.getGuest(0).getName(), "Jesse");
    }

    @Test
    public void canCheckOutGuests() {
        cct.checkIn(uncheckedGuests1, RoomType.SINGLE);
        assertEquals(1, bedroom1.getGuestNumber());
        cct.checkOut(7);
        assertEquals(0, bedroom1.getGuestNumber());
    }

    @Test
    public void canBookRoom(){
        Booking booking1 = cct.bookRoom(RoomType.SINGLE, 6);
        assertEquals(booking1.getBedroomBooked().getRoomNumber() , 7);
        assertEquals(booking1.getNightsBooked(), 6);
    }

    @Test
    public void canBillBooking(){
        Booking booking1 = cct.bookRoom(RoomType.SINGLE, 6);
        assertEquals(booking1.getBill(), 270.00, 0.0);
    }

    @Test
    public void HotelHasDiningRooms(){
        assertEquals(cct.getDiningRoom("La Salle a Manger").getName(), "La Salle a Manger");
    }

    @Test
    public void canGetVacantRooms(){
        assertEquals(cct.getVacantRooms().size(), 2);
        cct.checkIn(uncheckedGuests1, RoomType.SINGLE);
        assertEquals(cct.getVacantRooms().size(), 1);

    }

    @Test
    public void CanCheckInOnlyVacant() {
        assertEquals(0, bedroom1.getGuestNumber());
        assertEquals(0, bedroom2.getGuestNumber());
        cct.checkIn(uncheckedGuests1, RoomType.SINGLE);
        assertEquals(1, bedroom1.getGuestNumber());
        assertEquals(0, bedroom2.getGuestNumber());
        cct.checkIn(uncheckedGuests2, RoomType.SINGLE);
        assertEquals(1, bedroom1.getGuestNumber());
        assertEquals(1, bedroom2.getGuestNumber());
    }
}

