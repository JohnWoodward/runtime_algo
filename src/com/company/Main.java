package com.company;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    //Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. ∗/
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        for (int j = 0; j < n; j++) {
            double total = 0; // begin computing x[0] + ... + x[j]
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1); // record the average
        }
        return a;
    }


    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        double total = 0; // compute prefix sum as x[0] + x[1] + ...
        for (int j = 0; j < n; j++) {
            total += x[j]; // update prefix sum to include x[j]
            a[j] = total / (j + 1); // compute average based on current sum
        }
        return a;
    }


    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) { // loop from 0 to n-1
            total += arr[j];
        }
        return total;
    }


    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2) { // note the increment of 2
            total += arr[j];
        }
        return total;
    }


    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) // loop from 0 to n-1
            for (int k = 0; k <= j; k++) { // loop from 0 to j
                total += arr[j];
            }
        return total;
    }


    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0; j < n; j++) { // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }


    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) { // loop from 0 to n-1
            System.out.println("e5 current loop: " +i);
            int total = 0;
            for (int j = 0; j < n; j++) // loop from 0 to n-1
                for (int k = 0; k <= j; k++) { // loop from 0 to j
                    total += first[k];
                }
            if (second[i] == total) count++;
        }
        return count;
    }


    public static void main(String[] args) {

        int inputOne = Integer.parseInt(args[2]);
        double startTime;
        double endTime;
        double totalTime;
        PrintWriter outputStreamName;
        Random rand = new Random(System.currentTimeMillis());

        try {
            outputStreamName = new PrintWriter(new FileOutputStream(args[1]));


            for (int i = 1; i <= inputOne; i++) {


                int powerOne = (int) Math.pow(10, i);
                double[] arrayForPrefix = new double[powerOne];
                int[] arrayOneExample = new int[powerOne];
                int[] arrayTwoExample = new int[powerOne];

//                for (int j = 0; j < powerOne; j++) {
//                    arrayForPrefix[j] = (Math.random() * 10);
//                }
//
//                for (int j = 0; j < powerOne; j++) {
//                    arrayOneExample[j] = rand.nextInt(50) + 1;
//                    arrayTwoExample[j] = rand.nextInt(50) + 1;
//                }

                if (args[0].equals("p1")) {
                    startTime = System.nanoTime();
                    prefixAverage1(arrayForPrefix);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("p1 testComplete for power of" + i);
                } else if (args[0].equals("p2")) {
                    startTime = System.nanoTime();
                    prefixAverage2(arrayForPrefix);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("p2 testComplete for power of" + i);
                } else if (args[0].equals("e1")) {
                    startTime = System.nanoTime();
                    example1(arrayOneExample);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("e1 testComplete for power of" +i);
                } else if (args[0].equals("e2")) {
                    startTime = System.nanoTime();
                    example2(arrayOneExample);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("e2 testComplete for power of" + i);
                } else if (args[0].equals("e3")) {
                    startTime = System.nanoTime();
                    example3(arrayOneExample);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("e3 testComplete for power of" + i);
                } else if (args[0].equals("e4")) {
                    startTime = System.nanoTime();
                    example4(arrayOneExample);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("e4 testComplete for power of" + i);
                } else if (args[0].equals("e5")) {
                    startTime = System.nanoTime();
                    example5(arrayOneExample, arrayTwoExample);
                    endTime = System.nanoTime();
                    totalTime = Math.log10(endTime - startTime);
                    outputStreamName.println(totalTime);
                    System.out.println("e5 testComplete for power of" + i);
                }

            }
            outputStreamName.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[1] + "cannot be found.");
            System.exit(1);
        }

        int tenToTen[] = new int[1000000];
        example5(tenToTen, tenToTen);

    }
}

