package apachePoiApi;

import apachePoiApi.driveData;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Developed by Anand Singh on 03/Jul/2021, 1:38 AM.
 * Copyright (c) 2021. All rights reserved.
 */
public class testData {
    @Test
    public void test() throws IOException {
        driveData driveData = new driveData();
        System.out.println(driveData.getData("login"));
    }
}
