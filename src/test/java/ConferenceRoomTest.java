import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;
    private ArrayList guests;

    @Before

    public void before() {
        guest = new Guest("James");
        guests = new ArrayList<Guest>();
        guests.add(guest);
        conferenceRoom = new ConferenceRoom(50, "Orkney");
    }

    @Test
    public void canGetName() {
        assertEquals("Orkney", conferenceRoom.getName());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(50, conferenceRoom.getCapacity());
    }

    @Test
    public void canCheckGuestsNumber() {
        assertEquals(1, conferenceRoom.getGuestNumber());
    }
}
