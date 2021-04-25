package models.users;

import services.IdGenerator;

public class Passenger extends User {

    private String ticketId;
    private String trainNumber;
    private Integer carriageNumber;
    private Integer seat;

    public Passenger(String firstName, String lastName, Integer age, String trainNumber, Integer carriageNumber, Integer seat) {
        super(firstName, lastName, age);
        this.ticketId = IdGenerator.generateId(7);
        this.trainNumber = trainNumber;
        this.carriageNumber = carriageNumber;
        this.seat = seat;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public Integer getCarriageNumber() {
        return carriageNumber;
    }

    public Integer getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                super.toString()+
                ", ticketId='" + ticketId + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", carriageNumber='" + carriageNumber + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
