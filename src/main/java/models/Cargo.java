package models;

import services.IdGenerator;

public class Cargo {

    private String id;
    private Double weight;
    private String departureAddress;
    private String arrivalAddress;
    private String owner;

    public Cargo(Double weight, String departureAddress, String arrivalAddress, String owner) {
        id = IdGenerator.generateId(8);
        this.weight = weight;
        this.departureAddress = departureAddress;
        this.arrivalAddress = arrivalAddress;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public String getArrivalAddress() {
        return arrivalAddress;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress;
    }

    public void setArrivalAddress(String arrivalAddress) {
        this.arrivalAddress = arrivalAddress;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", departureAddress='" + departureAddress + '\'' +
                ", arrivalAddress='" + arrivalAddress + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
