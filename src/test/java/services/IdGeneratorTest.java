package services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IdGeneratorTest {

    @Test
    void generateIdValidTest(){
        //given
        int countOfSymb = 3;

        //when
        String id = IdGenerator.generateId(countOfSymb);
        int count = id.length();

        //then
        assertNotNull(id);
        assertEquals(countOfSymb, count);
    }

    @Test
    void generateIdInvalidTest(){
        //given
        int countOfSymb = -1;

        //when
        String id = IdGenerator.generateId(countOfSymb);
        int count = id.length();

        //then
        assertNotNull(id);
        assertEquals(0, count);
    }

}
