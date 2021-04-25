package data;

import models.Cargo;
import models.carriages.CargoCarriage;
import models.carriages.LocomotiveCarriage;
import models.carriages.PassengerCarriage;
import models.users.Driver;
import models.users.Passenger;

public class CarriageTestSamples {

    public static LocomotiveCarriage getLocomotiveCarriage(){
        Driver driver = UserTestSamples.getDriver();
        LocomotiveCarriage locomotiveCarriage = new LocomotiveCarriage(driver);
        return locomotiveCarriage;
    }

    public static PassengerCarriage getEmptyPassengerCarriage(){
        PassengerCarriage passengerCarriage = new PassengerCarriage(1);
        return passengerCarriage;
    }

    public static PassengerCarriage getFullPassengerCarriage(){
        PassengerCarriage passengerCarriage = new PassengerCarriage(1);
        Passenger passenger = UserTestSamples.getValidPassenger();
        passengerCarriage.getPassengers().set(0, passenger);
        return passengerCarriage;
    }

    public static CargoCarriage getEmptyCargoCarriage(){
        CargoCarriage cargoCarriage = new CargoCarriage(1000d);
        return cargoCarriage;
    }

    public static CargoCarriage getFullCargoCarriage(){
        CargoCarriage cargoCarriage = new CargoCarriage(1000d);
        Cargo cargo = CargoTestSamples.getHeavyCargo();
        cargoCarriage.getCargoes().add(cargo);
        cargoCarriage.setFreeCarrying(cargoCarriage.getFreeCarrying()-cargo.getWeight());
        return cargoCarriage;
    }
}
