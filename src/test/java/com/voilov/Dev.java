package com.voilov;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by root on 14.12.14.
 */
public class Dev {

    @Test
    public void test1() {
        List<String> actual = new ArrayList<String>();

        actual.add("Reasue: 2");
        actual.add("Fletcher: 3");

        System.out.println(actual);
        String[] expected = {"Fletcher: 3", "Reasure: 1"};

        List<String> expectedList = Arrays.asList(expected);

        Assert.assertEquals(actual, expectedList);
        //Assert.assertTrue(actual.containsAll(expectedList));

    }
}
