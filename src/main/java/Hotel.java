import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
    }

    public void getRoomOfType(RoomType roomType) {

    }

    public void checkIn(ArrayList<Guest> guests, Room room){
        for (Guest guest : guests) {
        room.getGuests().add(guest);
    }}

    public void checkout() {

    }

}
