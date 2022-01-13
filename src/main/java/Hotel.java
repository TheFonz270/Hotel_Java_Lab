import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private Bedroom theBedroom;
    private Booking booking;
    private HashMap<String, DiningRoom> diningRooms;
    private ArrayList<Bedroom> emptyBedrooms;


    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms, HashMap<String, DiningRoom> diningRooms){
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.diningRooms = diningRooms;
        this.emptyBedrooms = new ArrayList<>();
    }

    public Room getRoomOfType(RoomType roomType) {
        this.getVacantRooms();
        for (Bedroom room : emptyBedrooms) {
            if (room.getRoomType().equals(roomType)) {
                return room;
            }
    }
        return null;
    }

    public void checkIn(ArrayList<Guest> uncheckedGuests, RoomType roomType){

        for (Guest guest : uncheckedGuests) {
            this.getRoomOfType(roomType).getGuests().add(guest);
    }}

    public Room getRoomByNumber(int roomNumber) {

        for (Bedroom room : bedrooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    

    public void checkOut(int roomNumber) {
        theBedroom = (Bedroom) this.getRoomByNumber(roomNumber);
        theBedroom.guests.clear();
    }

    public Booking bookRoom(RoomType roomType, int nights){
        theBedroom = (Bedroom) this.getRoomOfType(roomType);
        booking = new Booking(theBedroom, nights);
        return booking;
    }

    public DiningRoom getDiningRoom(String name) {
        return diningRooms.get(name);
    }

    public ArrayList<Bedroom> getVacantRooms() {
        emptyBedrooms.clear();
        for (Bedroom room : bedrooms) {
            if (room.getGuestNumber() == 0) {
                emptyBedrooms.add(room);
            }
        }
        return emptyBedrooms;
    }

}
