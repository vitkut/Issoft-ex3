package data;

import models.users.Driver;
import models.users.Passenger;
import models.users.User;

import java.util.ArrayList;

public class UserTestSamples {

    public static User getAdultUser(){
        User user = new User("Steve", "Watson", 25);
        return user;
    }

    public static User getUnderageUser(){
        User user = new User("Patric", "Rios", 12);
        return user;
    }

    public static Passenger getValidPassenger(){
        Passenger passenger = new Passenger("Digby", "Santos", 22, "AAA", 2, 0);
        return passenger;
    }

    public static Passenger getInvalidPassenger(){
        Passenger passenger = new Passenger("Samon", "San", 22, "AAA", 2, 100);
        return passenger;
    }

    public static Driver getDriver(){
        Driver driver = new Driver("Shannon", "Parkinson", 45);
        return driver;
    }
}
