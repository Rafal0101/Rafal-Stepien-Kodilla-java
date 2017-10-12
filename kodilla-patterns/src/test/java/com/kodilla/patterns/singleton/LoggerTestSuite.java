package com.kodilla.patterns.singleton;

import com.kodilla.patterns.singleton.Logger;
import org.junit.Assert;

import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Some information.");
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals(log, "Some information.");
    }
}
