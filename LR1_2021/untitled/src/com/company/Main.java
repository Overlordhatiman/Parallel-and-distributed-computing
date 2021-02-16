package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void summaryArray(int size, int type)
    {
        long start = 0;
        long end = 0;

        switch (type)
        {
            case 0:
                double array[] = new double[size];

                for (int i=0;i<size;i++)
                    array[i]=i;

                double sum1=0;

                start = System.currentTimeMillis();

                for (int i=0;i<size;i++)
                    sum1+=array[i];

                end = System.currentTimeMillis();

                System.out.println("-----------------------");
                System.out.println("Size = " + size);
                System.out.println("Sum = " + (sum1));
                System.out.println("Time = " + (end - start));
                break;
            case 1:
                LinkedList<Double> linked_list = new LinkedList<Double>();

                for (int i=0;i<size;i++)
                    linked_list.add(new Double(i));

                double sum2=0;

                start = System.currentTimeMillis();

                for (int i=0;i<size;i++)
                    sum2+=linked_list.get(i);

                end = System.currentTimeMillis();

                System.out.println("-----------------------");
                System.out.println("Size = " + size);
                System.out.println("Sum = " + (sum2));
                System.out.println("Time = " + (end - start));
                break;
            case 2:
                ArrayList<Double> array_list = new ArrayList<Double>(size);

                for (int i=0;i<size;i++)
                    array_list.add(new Double(i));

                double sum3=0;

                start = System.currentTimeMillis();

                for (int i=0;i<size;i++)
                    sum3+=array_list.get(i);

                end = System.currentTimeMillis();

                System.out.println("-----------------------");
                System.out.println("Size = " + size);
                System.out.println("Sum = " + (sum3));
                System.out.println("Time = " + (end - start));
                break;
        }
    }

    public static void createArray(int n, int type)
    {
        float[][] array = new float[n][n];

        long start = 0;
        long end = 0;

        if (type == 0)
        {
            start = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = i+j;
                }
            }

            end = System.currentTimeMillis();
        }
        else
        {
            start = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[j][i] = i+j;
                }
            }

            end = System.currentTimeMillis();
        }

        System.out.println("-----------------------");
        System.out.println("Size = " + n);
        System.out.println("Bytes = " + (n*n*4/1024));
        System.out.println("Time = " + (end - start));
    }


    public static void main(String[] args) {

        /*
        for (int i = 0; i < 12000; i+=500) {
            createArray(i, 0);
        }

        for (int i = 0; i < 12000; i+=500) {
            createArray(i, 1);
        }*/

        for (int i = 0; i < 12000; i+=500) {
            summaryArray(i, 0);
        }
        for (int i = 0; i < 12000; i+=500) {
            summaryArray(i, 1);
        }
        for (int i = 0; i < 12000; i+=500) {
            summaryArray(i, 2);
        }
    }
}
