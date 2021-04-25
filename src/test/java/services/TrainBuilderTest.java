package services;

import data.CargoTestSamples;
import data.CarriageTestSamples;
import data.TrainTestSamples;
import data.UserTestSamples;
import models.Cargo;
import models.Train;
import models.carriages.CargoCarriage;
import models.carriages.PassengerCarriage;
import models.exceptions.TrainNotDeterminedException;
import models.users.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainBuilderTest {

    @Test
    void addCarriageValidTest(){
        //given
        Train train = TrainTestSamples.getValidEmptyTrain();
        TrainBuilder.setTrain(train);
        PassengerCarriage passengerCarriage = CarriageTestSamples.getEmptyPassengerCarriage();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addCarriage(passengerCarriage));
        assertEquals(passengerCarriage, train.getMainLocomotive().getNext());
    }

    @Test
    void addCarriageInvalidNullTrainTest(){
        //given
        TrainBuilder.setTrain(null);
        PassengerCarriage passengerCarriage = CarriageTestSamples.getEmptyPassengerCarriage();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addCarriage(passengerCarriage));
    }

    @Test
    void addCarriageInvalidNullLoco(){
        //given
        Train train = TrainTestSamples.getInvalidTrainNullLoco();
        TrainBuilder.setTrain(train);
        PassengerCarriage passengerCarriage = CarriageTestSamples.getEmptyPassengerCarriage();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addCarriage(passengerCarriage));
    }

    @Test
    void addPassengerValidTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Passenger passenger = UserTestSamples.getValidPassenger();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger));
        assertEquals(passenger, ((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().get(passenger.getSeat()));
    }

    @Test
    void addPassengerInvalidNullTrainTest(){
        //given
        TrainBuilder.setTrain(null);
        Passenger passenger = UserTestSamples.getValidPassenger();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addPassenger(passenger));
    }

    @Test
    void addPassengerInvalidNullLocoTest(){
        //given
        Train train = TrainTestSamples.getInvalidTrainNullLoco();
        TrainBuilder.setTrain(train);
        Passenger passenger = UserTestSamples.getValidPassenger();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addPassenger(passenger));
    }

    @Test
    void addPassengerInvalidTrainNumberTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Passenger passenger = UserTestSamples.getValidPassenger();
        passenger.setTrainNumber("000");

        //then
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger));
        assertNull(((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().get(passenger.getSeat()));
    }

    @Test
    void addPassengerInvalidCarriageNumberTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Passenger passenger = UserTestSamples.getValidPassenger();
        passenger.setCarriageNumber(0);

        //then
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger));
        assertNull(((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().get(passenger.getSeat()));
    }

    @Test
    void addPassengerInvalidSeatTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Passenger passenger = UserTestSamples.getInvalidPassenger();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger));
        assertFalse(((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().contains(passenger));
    }

    @Test
    void addPassengerInvalidSeatBusyTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Passenger passenger1 = UserTestSamples.getValidPassenger();
        Passenger passenger2 = UserTestSamples.getValidPassenger();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger1));
        assertEquals(passenger1, ((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().get(passenger1.getSeat()));
        assertDoesNotThrow(() -> TrainBuilder.addPassenger(passenger2));
        assertEquals(passenger1, ((PassengerCarriage) train.getMainLocomotive().getNext()).getPassengers().get(passenger2.getSeat()));
    }

    @Test
    void addCargoValidTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Cargo cargo = CargoTestSamples.getLightCargo();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addCargo(cargo));
        assertTrue(((CargoCarriage) train.getMainLocomotive().getNext().getNext()).getCargoes().contains(cargo));
    }

    @Test
    void addCargoInvalidNullTrainTest(){
        //given
        TrainBuilder.setTrain(null);
        Cargo cargo = CargoTestSamples.getLightCargo();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addCargo(cargo));
    }

    @Test
    void addCargoInvalidNullLocoTest(){
        //given
        Train train = TrainTestSamples.getInvalidTrainNullLoco();
        TrainBuilder.setTrain(train);
        Cargo cargo = CargoTestSamples.getLightCargo();

        //then
        assertThrows(TrainNotDeterminedException.class, () -> TrainBuilder.addCargo(cargo));
    }

    @Test
    void addCargoInvalidNoCargoCarriagesTest(){
        //given
        Train train = TrainTestSamples.getValidEmptyTrain();
        TrainBuilder.setTrain(train);
        Cargo cargo = CargoTestSamples.getLightCargo();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addCargo(cargo));
    }

    @Test
    void  addCargoInvalidNoFreeCarryingTest(){
        //given
        Train train = TrainTestSamples.getStandartTrain();
        TrainBuilder.setTrain(train);
        Cargo cargo1 = CargoTestSamples.getHeavyCargo();

        //then
        assertDoesNotThrow(() -> TrainBuilder.addCargo(cargo1));
        assertFalse(((CargoCarriage) train.getMainLocomotive().getNext().getNext()).getCargoes().contains(cargo1));
    }
}
