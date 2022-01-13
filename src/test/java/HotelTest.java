import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Guest guest1;
    private Bedroom bedroom;
    private ConferenceRoom cRoom;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> cRooms;
    private ArrayList<Guest> uncheckedGuests;
    private Hotel cct;


    @Before
    public void before(){
        guest1 = new Guest("Jesse");
        uncheckedGuests = new ArrayList<Guest>();
        uncheckedGuests.add(guest1);
        bedroom = new Bedroom(1, RoomType.SINGLE, 7 );
        cRoom = new ConferenceRoom(50, "Orkney");
        bedrooms = new ArrayList<>();
        cRooms = new ArrayList<>();
        cRooms.add(cRoom);
        bedrooms.add(bedroom);
        cct = new Hotel(bedrooms, cRooms);
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

}
