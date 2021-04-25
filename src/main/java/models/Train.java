package models;

import models.carriages.LocomotiveCarriage;
import services.IdGenerator;

import java.util.ArrayList;
import java.util.Date;

public class Train {

    private String trainNumber;
    private Date departureTime;
    private Date arrivalTime;
    private String departureAddress;
    private String arrivalAddress;
    private LocomotiveCarriage mainLocomotive;

    public Train(Date departureTime,
                 Date arrivalTime, String departureAddress, String arrivalAddress, LocomotiveCarriage mainLocomotive) {
        this.trainNumber = IdGenerator.generateId(3);
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

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress;
    }

    public void setArrivalAddress(String arrivalAddress) {
        this.arrivalAddress = arrivalAddress;
    }

    public void setMainLocomotive(LocomotiveCarriage mainLocomotive) {
        this.mainLocomotive = mainLocomotive;
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
