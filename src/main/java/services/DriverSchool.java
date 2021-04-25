package services;

import models.users.Driver;
import models.exceptions.UnderageUserException;
import models.users.User;

public class DriverSchool {

    public static Driver teach(User user) throws UnderageUserException{
        if(user.getAge() < 18){
            throw new UnderageUserException();
        }
        return new Driver(user.getFirstName(), user.getLastName(), user.getAge());
    }

}
