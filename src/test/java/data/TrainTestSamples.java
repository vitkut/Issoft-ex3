package data;

import models.Train;
import models.carriages.CargoCarriage;
import models.carriages.PassengerCarriage;
import models.users.Passenger;

import java.util.Date;

public class TrainTestSamples {

    public static Train getValidEmptyTrain(){
        Train train = new Train(new Date(2021, 4, 1, 20, 20),
                new Date(2021, 4, 1, 21, 20), "Minsk",
                "Moscow", CarriageTestSamples.getLocomotiveCarriage());
        train.setTrainNumber("AAA");
        return train;
    }

    public static Train getInvalidTrainNullLoco(){
        Train train = new Train(new Date(2021, 4, 1, 20, 20),
                new Date(2021, 4, 1, 21, 20), "Minsk",
                "Moscow", null);
        train.setTrainNumber("AAA");
        return train;
    }

    public static Train getStandartTrain(){
        Train train = new Train(new Date(2021, 4, 1, 20, 20),
                new Date(2021, 4, 1, 21, 20), "Minsk",
                "Moscow", CarriageTestSamples.getLocomotiveCarriage());
        PassengerCarriage passengerCarriage = CarriageTestSamples.getEmptyPassengerCarriage();
        CargoCarriage cargoCarriage = CarriageTestSamples.getEmptyCargoCarriage();
        train.getMainLocomotive().setNext(passengerCarriage);
        passengerCarriage.setNext(cargoCarriage);
        train.setTrainNumber("AAA");
        return train;
    }
}
