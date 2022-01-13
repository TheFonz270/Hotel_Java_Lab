import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private Bedroom theBedroom;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
    }

    public void getRoomOfType(RoomType roomType) {

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
    

    public void checkout() {

    }

}
