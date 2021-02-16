package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;


class HashSetTest {

    @Test
    public void testCheckAll() {
        final HashSet<Integer> aHashStructure = new HashSet<Integer>();

        for(int i = 0; i < 10000000; i++)
        {
            aHashStructure.add(i);
        }
        long start = System.currentTimeMillis();

        for(int i = 0; i< 10000000; i++)
        {
            int aElement = i;
            assertTrue(aHashStructure.contains(aElement));
        }

        long end = System.currentTimeMillis();

        System.out.println("Time =" + (end-start));

    }

    @Test
    public void testCheckSingle() {
        final HashSet<Integer> aHashStructure = new HashSet<Integer>();

        for(int i = 0; i < 10000000; i++)
        {
            aHashStructure.add(i);
        }
        long start = System.currentTimeMillis();

        int aElement = 0;
        for(int i = 0; i< 10000000; i++)
        {
            assertTrue(aHashStructure.contains(aElement));
        }

        long end = System.currentTimeMillis();

        System.out.println("Time =" + (end-start));

    }

}