package services;

import models.users.Driver;
import models.exceptions.UnderageUserException;
import models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSchool {

    private static final Logger logger = LoggerFactory.getLogger(DriverSchool.class);

    public static Driver training(User user) throws UnderageUserException{
        logger.debug("-Start training()");

        if(user == null){
            throw new NullPointerException("User is null");
        }

        logger.debug("User is not null");

        if(user.getAge() < 18){
            throw new UnderageUserException();
        }

        logger.debug("Driver trained");
        logger.debug("-Finish training()");

        return new Driver(user.getFirstName(), user.getLastName(), user.getAge());
    }

}
