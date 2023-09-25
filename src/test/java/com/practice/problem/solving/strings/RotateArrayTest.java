package com.practice.problem.solving.strings;

import com.practice.problem.solving.array.rotatearray.RotateArray;
import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    @Test
    public void testReverseStringByBuilder(){
        RotateArray rotateArray = new RotateArray();
        int[] inputArray = {1,2,3,4,5,6};
        int[] outputArray = {3,4,5,6,1,2};
        Assert.assertArrayEquals(outputArray,rotateArray.rotateArrayBySizeOfRotation(inputArray,2));
    }

}
