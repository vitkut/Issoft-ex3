import models.Cargo;
import models.Train;
import models.carriages.CargoCarriage;
import models.carriages.Carriage;
import models.carriages.LocomotiveCarriage;
import models.carriages.PassengerCarriage;
import models.exceptions.CarriageNotDeterminedException;
import models.exceptions.TrainNotDeterminedException;
import models.users.Driver;
import models.users.Passenger;
import models.exceptions.UnderageUserException;
import models.users.User;
import services.DriverSchool;
import services.IdGenerator;
import services.TrainBuilder;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            //Create users

            //Create driver
            Driver driver = DriverSchool.teach(new User("Ivan", "Shot", 20));

            //Create carriages
            LocomotiveCarriage loco = new LocomotiveCarriage(driver);
            PassengerCarriage passengerCarriage = new PassengerCarriage(5);
            CargoCarriage cargoCarriage = new CargoCarriage(1000d);

            //Create train
            String trainNumber = IdGenerator.generateId(3);
            Date departureTime = new Date(2021, 4, 25, 20, 0);
            Date arrivalTime = new Date(2021, 4, 26, 20, 0);
            String departureAddress = "Minsk-Pass";
            String arrivalAddress = "Molodechno";
            Train train = new Train(trainNumber, departureTime, arrivalTime, departureAddress, arrivalAddress, loco);
            TrainBuilder.setTrain(train);
            TrainBuilder.addCarriage(passengerCarriage);
            TrainBuilder.addCarriage(cargoCarriage);

            //Create passengers
            Passenger passenger1 = new Passenger("Andrey", "Fast", 23, trainNumber, 2, 3);
            Passenger passenger2 = new Passenger("Inna", "Fast", 22, trainNumber, 2, 4);

            //Create cargoes
            Cargo cargo1 = new Cargo(100d, departureAddress, arrivalAddress, "USA inc.");
            Cargo cargo2 = new Cargo(202d, departureAddress, arrivalAddress, "SoftSoftSoft");

            //Add passengers
            TrainBuilder.addPassenger(passenger1);
            TrainBuilder.addPassenger(passenger2);

            //Add cargoes
            TrainBuilder.addCargo(cargo1);
            TrainBuilder.addCargo(cargo2);

            //Print train
            printTrain(train);

        } catch (UnderageUserException | TrainNotDeterminedException ex){
            System.out.println(ex.getMessage());//rewrite
        }
    }

    public static void printTrain(Train train){
        System.out.println("==================================");
        System.out.println("train number = "+train.getTrainNumber());
        System.out.println("departure time = "+train.getDepartureTime());
        System.out.println("arrival time = "+train.getArrivalTime());
        System.out.println("departure address = "+train.getDepartureAddress());
        System.out.println("arrival address = "+train.getArrivalAddress());
        System.out.println("==================================");
        Carriage carriage = train.getMainLocomotive();
        while (carriage != null){
            if(carriage instanceof LocomotiveCarriage){
                LocomotiveCarriage locomotiveCarriage = (LocomotiveCarriage) carriage;
                System.out.println("------------------------------");
                System.out.println("\tLocomotive carriage");
                System.out.println("carriage id = "+locomotiveCarriage.getId());
                System.out.println("driver = "+locomotiveCarriage.getDriver());
                System.out.println("------------------------------");
                System.out.println("  X                        X  ");
            }
            if(carriage instanceof PassengerCarriage){
                PassengerCarriage passengerCarriage = (PassengerCarriage) carriage;
                System.out.println("------------------------------");
                System.out.println("\tPassenger carriage");
                System.out.println("carriage id = "+passengerCarriage.getId());
                System.out.println("seats = "+passengerCarriage.getSeats());
                System.out.println("passengers = [");
                for(int i = 0; i < passengerCarriage.getPassengers().size(); i++){
                    System.out.println("N"+i+": "+passengerCarriage.getPassengers().get(i));
                }
                System.out.println("]");
                System.out.println("------------------------------");
                System.out.println("  X                        X  ");
            }
            if(carriage instanceof CargoCarriage){
                CargoCarriage cargoCarriage = (CargoCarriage) carriage;
                System.out.println("------------------------------");
                System.out.println("\tCargo carriage");
                System.out.println("carriage id = "+cargoCarriage.getId());
                System.out.println("carrying = "+cargoCarriage.getCarrying());
                System.out.println("free carrying = "+cargoCarriage.getFreeCarrying());
                System.out.println("cargoes = [");
                for(int i = 0; i < cargoCarriage.getCargos().size(); i++){
                    System.out.println("N"+i+": "+cargoCarriage.getCargos().get(i));
                }
                System.out.println("]");
                System.out.println("------------------------------");
                System.out.println("  X                        X  ");
            }
            carriage = carriage.getNext();
        }
    }

}
