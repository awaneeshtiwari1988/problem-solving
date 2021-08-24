package com.practice.problem.solving.strings;

import com.practice.problem.solving.array.KLargestElementByHeapSort;
import com.practice.problem.solving.array.KLargestElementBySelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class KLargestElementBySelectionSortTest {

    @Test
    public void testGetKLargestElements(){
        KLargestElementBySelectionSort kLargestElementBySelectionSort = new KLargestElementBySelectionSort();
        int[] inputArray = {12, 5, 787, 1, 23};
        int[] expectedOutPut = {787,23};
        Assert.assertArrayEquals(expectedOutPut,kLargestElementBySelectionSort.getKLargestElements(inputArray,2));
    }

    @Test
    public void testGetKLargestElements_Input1(){
        KLargestElementByHeapSort kLargestElementByHeapSort = new KLargestElementByHeapSort();
        int[] inputArray = {335, 501, 170 ,725, 479 ,359, 963 ,465 ,706 ,146, 282, 828 ,962 ,492, 996 ,943 ,828 ,437, 392, 605 ,903 ,154, 293 ,383 ,422 ,717, 719 ,896, 448, 727, 772 ,539 ,870 ,913, 668 ,300 ,36 ,895 ,704 ,812 ,323 ,334};
        int[] expectedOutPut = {996, 963, 962, 943, 913, 903, 896, 895, 870, 828, 828, 812, 772, 727, 725, 719, 717, 706, 704, 668, 605, 539, 501, 492, 479, 465, 448, 437, 422, 392};
        Assert.assertArrayEquals(expectedOutPut,kLargestElementByHeapSort.getKLargestElements(inputArray,30));
    }

    @Test
    public void testGetKLargestElements_Heap(){
        KLargestElementByHeapSort kLargestElementByHeapSort = new KLargestElementByHeapSort();
        int[] inputArray = {1,23,12,9,30,2,50};
        int[] expectedOutPut = {50,30,23};
        Assert.assertArrayEquals(expectedOutPut,kLargestElementByHeapSort.getKLargestElements(inputArray,3));
    }
}
