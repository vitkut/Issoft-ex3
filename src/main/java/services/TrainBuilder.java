package services;

import models.Cargo;
import models.carriages.CargoCarriage;
import models.carriages.PassengerCarriage;
import models.exceptions.CarriageNotDeterminedException;
import models.exceptions.TrainNotDeterminedException;
import models.users.Passenger;
import models.Train;
import models.carriages.Carriage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainBuilder {

    private static Train train = null;

    private static final Logger logger = LoggerFactory.getLogger(TrainBuilder.class);

    public static void setTrain(Train train) {
        TrainBuilder.train = train;
    }

    public static void addCarriage(Carriage carriage) throws TrainNotDeterminedException{
        logger.debug("-Start addCarriage()");

        if(train == null){
            throw new TrainNotDeterminedException();
        }

        logger.debug("Train determined");

        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }

        logger.debug("Main locomotive determined");

        Carriage lastCarriage = train.getMainLocomotive();
        while (lastCarriage.getNext() != null){
            lastCarriage = lastCarriage.getNext();
        }
        lastCarriage.setNext(carriage);

        logger.debug("Carriage added");
        logger.debug("-Finish addCarriage()");
    }

    public static void addPassenger(Passenger passenger) throws TrainNotDeterminedException{
        logger.debug("-Start addPassenger()");

        if(train == null){
            throw new TrainNotDeterminedException();
        }

        logger.debug("Train determined");

        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }

        logger.debug("Main locomotive determined");

        try {
            if(!passenger.getTrainNumber().equals(train.getTrainNumber())){
                throw new CarriageNotDeterminedException("Train numbers is not equals");
            }

            if(passenger.getCarriageNumber() <= 1){
                throw new CarriageNotDeterminedException("Carriage number is not valid");
            }

            logger.debug("Passenger training number checked");

            Carriage carriage = train.getMainLocomotive();
            for(int i = 1; i < passenger.getCarriageNumber(); i++){
                if(carriage.getNext() == null){
                    throw new CarriageNotDeterminedException("Passenger carriage is not determined");
                }
                carriage = carriage.getNext();
            }
            if(!(carriage instanceof PassengerCarriage)){
                throw new CarriageNotDeterminedException("Passenger carriage is not determined");
            }

            logger.debug("Passenger carriage number checked");

            PassengerCarriage passengerCarriage = (PassengerCarriage) carriage;
            if(passenger.getSeat() > passengerCarriage.getSeats() ||
                    passengerCarriage.getPassengers().get(passenger.getSeat()) != null){
                throw new CarriageNotDeterminedException("Passenger seat is not determined");
            }

            logger.debug("Passenger seat checked");

            passengerCarriage.getPassengers().set(passenger.getSeat(), passenger);

            logger.debug("Passenger added");
        } catch (CarriageNotDeterminedException ex){
            logger.error(ex.getMessage());
        }

        logger.debug("-Finish addPassenger()");
    }

    public static void addCargo(Cargo cargo) throws TrainNotDeterminedException{
        logger.debug("-Start addCargo()");

        if(train == null){
            throw new TrainNotDeterminedException();
        }

        logger.debug("Train determined");

        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }

        logger.debug("Main locomotive determined");

        try{
            boolean isAdded = false;
            Carriage carriage = train.getMainLocomotive();
            while (!isAdded){
                if(carriage.getNext() == null){
                    throw new CarriageNotDeterminedException("Free cargo carriage is not determined");
                }
                carriage = carriage.getNext();
                if(carriage instanceof CargoCarriage){
                    CargoCarriage cargoCarriage = (CargoCarriage) carriage;
                    if(cargoCarriage.getFreeCarrying()-cargo.getWeight() > 0d){
                        cargoCarriage.getCargoes().add(cargo);
                        cargoCarriage.setFreeCarrying(cargoCarriage.getFreeCarrying()-cargo.getWeight());
                        isAdded = true;

                        logger.debug("Cargo added");
                    }
                }
            }
        } catch (CarriageNotDeterminedException ex){
            logger.error(ex.getMessage());
        }

        logger.debug("-Finish addCargo()");
    }
}
