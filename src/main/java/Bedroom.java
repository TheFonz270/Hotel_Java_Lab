import java.util.ArrayList;


public class Bedroom extends Room {

    private RoomType roomType;
    private int roomNumber;
    private double nightlyRate;

    public Bedroom(int capacity, RoomType roomType, int roomNumber) {
        super(capacity);
        this.guests = new ArrayList<Guest>();
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }
}
