package data;

import models.Cargo;

public class CargoTestSamples {

    public static Cargo getLightCargo(){
        Cargo cargo = new Cargo(0.0001, "Minsk", "Minsk", "MTS");
        return cargo;
    }

    public static Cargo getHeavyCargo(){
        Cargo cargo = new Cargo(1000d, "Minsk", "Moscow", "USA");
        return cargo;
    }

}
