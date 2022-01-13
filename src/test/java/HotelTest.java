import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Guest guest1;
    private Bedroom bedroom;
    private ConferenceRoom cRoom;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> cRooms;
    private ArrayList<Guest> uncheckedGuests;
    private Hotel cct;
    private Booking booking;
    private DiningRoom laChambre;
    private DiningRoom laCuisine;
    private DiningRoom laSalleAManger;
    private HashMap<String, DiningRoom> diningRooms;


    @Before
    public void before(){
        guest1 = new Guest("Jesse");
        uncheckedGuests = new ArrayList<>();
        uncheckedGuests.add(guest1);
        bedroom = new Bedroom(1, RoomType.SINGLE, 7, 45.00 );
        cRoom = new ConferenceRoom(50, "Orkney");
        bedrooms = new ArrayList<>();
        cRooms = new ArrayList<>();
        cRooms.add(cRoom);
        bedrooms.add(bedroom);
        laChambre = new DiningRoom("La Chambre", 20);
        laSalleAManger = new DiningRoom("La Salle a Manger", 50);
        laCuisine = new DiningRoom("La Cuisine", 15);
        diningRooms = new HashMap<>();
        diningRooms.put("La Chambre", laChambre);
        diningRooms.put("La Salle a Manger", laSalleAManger);
        diningRooms.put("La Cuisine", laCuisine);
        cct = new Hotel(bedrooms, cRooms, diningRooms);
        booking = new Booking(bedroom, 5);
    }

    @Test
    public void canGetRoomOfType() {
        assertEquals(cct.getRoomOfType(RoomType.SINGLE), bedroom);
    }

    @Test
    public void canCheckInSingle(){
    cct.checkIn(uncheckedGuests, RoomType.SINGLE );
    assertEquals(bedroom.getGuest(0).getName(), "Jesse");
    }

    @Test
    public void canCheckOutGuests() {
        cct.checkIn(uncheckedGuests, RoomType.SINGLE);
        assertEquals(1, bedroom.getGuestNumber());
        cct.checkOut(7);
        assertEquals(0, bedroom.getGuestNumber());
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
}

