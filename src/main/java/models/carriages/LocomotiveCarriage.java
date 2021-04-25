package models.carriages;

import models.users.Driver;

public class LocomotiveCarriage extends Carriage {

    private Driver driver;

    public LocomotiveCarriage(Driver driver) {
        super();
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "LocomotiveCarriage{" +
                super.toString() +
                ", driver=" + driver +
                '}';
    }
}
