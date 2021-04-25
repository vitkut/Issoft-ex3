package models.carriages;

import models.users.Passenger;

import java.util.ArrayList;

public class PassengerCarriage extends Carriage {

    private Integer seats;
    private ArrayList<Passenger> passengers;

    public PassengerCarriage(Integer seats) {
        super();
        this.seats = seats;
        this.passengers = new ArrayList<>();
        for(int i = 0; i < seats; i++){
            passengers.add(null);
        }
    }

    public Integer getSeats() {
        return seats;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "PassengerCarriage{" +
                super.toString() +
                ", seats=" + seats +
                ", passengers=" + passengers +
                '}';
    }
}
