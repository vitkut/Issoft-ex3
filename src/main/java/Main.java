import models.Cargo;
import models.Train;
import models.carriages.CargoCarriage;
import models.carriages.Carriage;
import models.carriages.LocomotiveCarriage;
import models.carriages.PassengerCarriage;
import models.exceptions.TrainNotDeterminedException;
import models.users.Driver;
import models.users.Passenger;
import models.exceptions.UnderageUserException;
import models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DriverSchool;
import services.IdGenerator;
import services.TrainBuilder;

import java.util.Date;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("-Start main()");
        try {
            //Create driver
            Driver driver = DriverSchool.training(new User("Ivan", "Shot", 20));

            logger.debug("Created driver");

            //Create carriages
            LocomotiveCarriage loco = new LocomotiveCarriage(driver);
            PassengerCarriage passengerCarriage = new PassengerCarriage(5);
            CargoCarriage cargoCarriage = new CargoCarriage(1000d);

            logger.debug("Created carriages");

            //Create training
            Date departureTime = new Date(2021, 4, 25, 20, 0);
            Date arrivalTime = new Date(2021, 4, 26, 20, 0);
            String departureAddress = "Minsk-Pass";
            String arrivalAddress = "Molodechno";
            Train train = new Train(departureTime, arrivalTime, departureAddress, arrivalAddress, loco);
            String trainNumber = train.getTrainNumber();
            TrainBuilder.setTrain(train);
            TrainBuilder.addCarriage(passengerCarriage);
            TrainBuilder.addCarriage(cargoCarriage);

            logger.debug("Created training");

            //Create passengers
            Passenger passenger1 = new Passenger("Andrey", "Fast", 23, trainNumber, 2, 3);
            Passenger passenger2 = new Passenger("Inna", "Fast", 22, trainNumber, 2, 4);

            logger.debug("Created passengers");

            //Create cargoes
            Cargo cargo1 = new Cargo(100d, departureAddress, arrivalAddress, "USA inc.");
            Cargo cargo2 = new Cargo(202d, departureAddress, arrivalAddress, "SoftSoftSoft");

            logger.debug("Created cargoes");

            //Add passengers
            TrainBuilder.addPassenger(passenger1);
            TrainBuilder.addPassenger(passenger2);

            logger.debug("Added passengers");

            //Add cargoes
            TrainBuilder.addCargo(cargo1);
            TrainBuilder.addCargo(cargo2);

            logger.debug("Added cargoes");

            //Print training
            printTrain(train);

            logger.debug("Train printed");

        } catch (UnderageUserException | TrainNotDeterminedException ex){
            logger.error(ex.getMessage());
        }
        logger.debug("-Finish main()");
    }

    public static void printTrain(Train train){
        System.out.println("==================================");
        System.out.println("training number = "+train.getTrainNumber());
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
                for(int i = 0; i < cargoCarriage.getCargoes().size(); i++){
                    System.out.println("N"+i+": "+cargoCarriage.getCargoes().get(i));
                }
                System.out.println("]");
                System.out.println("------------------------------");
                System.out.println("  X                        X  ");
            }
            carriage = carriage.getNext();
        }
    }

}
