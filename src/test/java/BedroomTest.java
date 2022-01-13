import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Guest guest1;
    private Bedroom bedroom;
    private ArrayList guests;

    @Before
    public void before(){
        guest1 = new Guest("Jesse");
        guests = new ArrayList<Guest>();
        guests.add(guest1);
        bedroom = new Bedroom(1, RoomType.SINGLE, 7, 45.00 );
    }

    @Test
    public void bedroomExists(){
        assertEquals(1, bedroom.getCapacity());
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
        assertEquals(7, bedroom.getRoomNumber());
        assertEquals(45.00, bedroom.getNightlyRate(), 0.0);
    }

    @Test
    public void bedroomHasGuest(){
        assertEquals("Jesse", bedroom.getGuestName(0));
    }
}
