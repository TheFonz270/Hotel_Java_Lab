import java.util.ArrayList;

public abstract class Room {

    protected int capacity;
    protected ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public Guest getGuest(int index) {
        return guests.get(index);
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public String getGuestName(int index) {
        return guests.get(index).getName();
    }

    public int getGuestNumber() {
        return guests.size();
    }


}
