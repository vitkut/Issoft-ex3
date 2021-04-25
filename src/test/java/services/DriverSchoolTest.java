package services;

import data.UserTestSamples;
import models.exceptions.UnderageUserException;
import models.users.Driver;
import models.users.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverSchoolTest {

    @Test
    void trainingValidUserTest(){
        //given
        User user = UserTestSamples.getAdultUser();

        //then
        assertDoesNotThrow(() -> DriverSchool.training(user));
        try{
            assertNotEquals(DriverSchool.training(user), null);
        } catch (UnderageUserException ex){

        }
    }

    @Test
    void trainingInvalidUserTest(){
        //given
        User user1 = UserTestSamples.getUnderageUser();
        User user2 = null;

        //then
        assertThrows(UnderageUserException.class, () -> DriverSchool.training(user1));
        assertThrows(NullPointerException.class, () -> DriverSchool.training(user2));
    }
}
