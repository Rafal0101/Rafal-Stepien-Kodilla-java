package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void newLog() {
        Logger.getInstance().log("Some information.");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals(log, "Some information.");
    }
}
