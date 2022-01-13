import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private Guest guest1;
    private Guest guest2;
    private ArrayList<Guest> guests;
    private DiningRoom leChambre;

    @Before
    public void before(){
        leChambre = new DiningRoom("Le Chambre", 30);
        guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
    }

    @Test
    public void DiningRoomExists(){
        assertEquals(leChambre.getName(), "Le Chambre");
        assertEquals(leChambre.getCapacity(), 30);
        assertEquals(leChambre.getGuestsSize(),0);
    }

    @Test
    public void CanAddGuests(){
        leChambre.setGuests(guests);
        assertEquals(leChambre.getGuestsSize(), 2);
    }
}
