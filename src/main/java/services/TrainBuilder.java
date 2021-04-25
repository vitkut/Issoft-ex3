package services;

import models.Cargo;
import models.carriages.CargoCarriage;
import models.carriages.PassengerCarriage;
import models.exceptions.CarriageNotDeterminedException;
import models.exceptions.TrainNotDeterminedException;
import models.users.Passenger;
import models.Train;
import models.carriages.Carriage;

public class TrainBuilder {

    private static Train train;

    public static void setTrain(Train train) {
        TrainBuilder.train = train;
    }

    public static void addCarriage(Carriage carriage) throws TrainNotDeterminedException{
        if(train == null){
            throw new TrainNotDeterminedException();
        }
        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }
        Carriage lastCarriage = train.getMainLocomotive();
        while (lastCarriage.getNext() != null){
            lastCarriage = lastCarriage.getNext();
        }
        lastCarriage.setNext(carriage);
    }

    public static void addPassenger(Passenger passenger) throws TrainNotDeterminedException{
        if(train == null){
            throw new TrainNotDeterminedException();
        }
        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }
        try {
            if(!passenger.getTrainNumber().equals(train.getTrainNumber())){
                throw new CarriageNotDeterminedException("Train numbers is not equals");
            }
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
            PassengerCarriage passengerCarriage = (PassengerCarriage) carriage;
            if(passenger.getSeat() > passengerCarriage.getSeats() ||
                    passengerCarriage.getPassengers().get(passenger.getSeat()) != null){
                throw new CarriageNotDeterminedException("Passenger seat is not determined");
            }
            passengerCarriage.getPassengers().set(passenger.getSeat(), passenger);
        } catch (CarriageNotDeterminedException ex){
            System.out.println(ex.getMessage());//rewrite
        }

    }

    public static void addCargo(Cargo cargo) throws TrainNotDeterminedException{
        if(train == null){
            throw new TrainNotDeterminedException();
        }
        if(train.getMainLocomotive() == null){
            throw new TrainNotDeterminedException("Main locomotive is not determined");
        }
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
                        cargoCarriage.getCargos().add(cargo);
                        cargoCarriage.setFreeCarrying(cargoCarriage.getFreeCarrying()-cargo.getWeight());
                        isAdded = true;
                    }
                }
            }
        } catch (CarriageNotDeterminedException ex){
            System.out.println(ex.getMessage());//rewrite
        }

    }
}
