package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    public static String generateId(int countOfSymb){
        logger.debug("-Start generateId()");

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < countOfSymb; i++){
            double randNum = Math.random();//(0;1)
            if(Math.random() >= 0.5){
                //letters ascii [65;90]
                randNum *= 26;//(0;26)
                int num = (int) Math.round(randNum);//[0;25]
                num += 65;//[65;90]
                stringBuilder.append((char) num);//to ascii
            } else {
                //numbers
                randNum *= 10; //(0;10)
                int num = (int) Math.round(randNum); // [0;9]
                stringBuilder.append(num);
            }
        }

        logger.debug("Id generated");
        logger.debug("-Finish generateId()");

        return stringBuilder.toString();
    }
}
