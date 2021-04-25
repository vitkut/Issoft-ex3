package models;

import models.carriages.LocomotiveCarriage;

import java.util.ArrayList;
import java.util.Date;

public class Train {

    private String trainNumber;
    private Date departureTime;
    private Date arrivalTime;
    private String departureAddress;
    private String arrivalAddress;
    private LocomotiveCarriage mainLocomotive;

    public Train(String trainNumber, Date departureTime,
                 Date arrivalTime, String departureAddress, String arrivalAddress, LocomotiveCarriage mainLocomotive) {
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAddress = departureAddress;
        this.arrivalAddress = arrivalAddress;
        this.mainLocomotive = mainLocomotive;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public String getArrivalAddress() {
        return arrivalAddress;
    }

    public LocomotiveCarriage getMainLocomotive() {
        return mainLocomotive;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureAddress='" + departureAddress + '\'' +
                ", arrivalAddress='" + arrivalAddress + '\'' +
                ", mainLocomotive=" + mainLocomotive +
                '}';
    }
}
