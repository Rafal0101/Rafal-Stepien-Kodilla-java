package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        int[] exampleTable = {1, 2, 3, 4, 5, 6, 7, 8};  //average = 4,5
        Assert.assertEquals(4.5, ArrayOperations.getAverage(exampleTable), 0.1);
    }
}
