package com.company;

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
        for (int j = 0; j < n; j++) // loop from 0 to n-1
            total += arr[j];
        return total;
    }


    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2) // note the increment of 2
            total += arr[j];
        return total;
    }


    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) // loop from 0 to n-1
            for (int k = 0; k <= j; k++) // loop from 0 to j
                total += arr[j];
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
            int total = 0;
            for (int j = 0; j < n; j++) // loop from 0 to n-1
                for (int k = 0; k <= j; k++) // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        // write your code here
    }
}
