package logging1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Developed by Anand Singh on 03/Jul/2021, 7:47 PM.
 * Copyright (c) 2021. All rights reserved.
 */
public class TestLogging1 {
    private static Logger Log = LogManager.getLogger(TestLogging1.class.getName());
    @Test
    public void loggingTest(){
        Log.debug("I am debugging.");
        Log.info("I am Info.");
        if(true){
            Log.error("I am true error.");
        } else {
            Log.error("I am false error.");
        }
    }
}
