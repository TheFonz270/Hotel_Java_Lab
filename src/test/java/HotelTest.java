import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HotelTest {

    private Guest guest1;
    private Bedroom bedroom;
    private ConferenceRoom cRoom;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> cRooms;
    private ArrayList uncheckedGuests;
    private Hotel cct;


    @Before
    public void before(){
        guest1 = new Guest("Jesse");
        uncheckedGuests = new ArrayList<Guest>();
        uncheckedGuests.add(guest1);
        bedroom = new Bedroom(1, RoomType.SINGLE, 7 );
        cRoom = new ConferenceRoom(50, "Orkney");
        bedrooms = new ArrayList<Bedroom>();
        cRooms = new ArrayList<ConferenceRoom>();
        cRooms.add(cRoom);
        bedrooms.add(bedroom);
        cct = new Hotel(bedrooms, cRooms);
    }

    @Test
    public void canCheckInSingle(){
    cct.checkIn();
    }

}
