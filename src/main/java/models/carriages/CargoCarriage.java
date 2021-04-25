package models.carriages;

import models.Cargo;

import java.util.ArrayList;

public class CargoCarriage extends Carriage {

    private Double carrying;
    private Double freeCarrying;
    private ArrayList<Cargo> cargoes;

    public CargoCarriage(Double carrying) {
        this.carrying = carrying;
        this.freeCarrying = carrying;
        this.cargoes = new ArrayList<Cargo>();
    }

    public Double getCarrying() {
        return carrying;
    }

    public Double getFreeCarrying() {
        return freeCarrying;
    }

    public ArrayList<Cargo> getCargos() {
        return cargoes;
    }

    public void setFreeCarrying(Double freeCarrying) {
        this.freeCarrying = freeCarrying;
    }

    @Override
    public String toString() {
        return "CargoCarriage{" +
                super.toString() +
                ", carrying=" + carrying +
                ", freeCarrying=" + freeCarrying +
                ", cargoes=" + cargoes +
                '}';
    }
}
