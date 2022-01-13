public class Booking {

    private Bedroom bedroomBooked;
    private int nightsBooked;

    public Booking(Bedroom bedroom, int nightsBooked){
        this.bedroomBooked = bedroom;
        this.nightsBooked = nightsBooked;
    }

    public Bedroom getBedroomBooked() {
        return bedroomBooked;
    }

    public int getNightsBooked() {
        return nightsBooked;
    }

    public double getBill(){
        return this.nightsBooked * this.bedroomBooked.getNightlyRate();
    }
}
