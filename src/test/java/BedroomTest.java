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
        bedroom = new Bedroom(1, RoomType.SINGLE, 7 );
    }

    @Test
    public void bedroomExists(){
        assertEquals(1, bedroom.getCapacity());
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
        assertEquals(7, bedroom.getRoomNumber());
    }

    @Test
    public void bedroomHasGuest(){
        assertEquals("Jesse", bedroom.getGuest(0));
    }
}
