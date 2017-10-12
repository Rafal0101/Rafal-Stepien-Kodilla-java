package com.kodilla.patterns.patterns.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        int[] exampleTable = {5, 6, 7, 8};  //average = 4,5
        Assert.assertEquals(6.5, ArrayOperations.getAverage(exampleTable), 0.1);
    }
}
