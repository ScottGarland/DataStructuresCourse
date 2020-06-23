package ca.ScottGarland.DataStructures;

import java.util.Arrays;
import java.util.Random;

public class Tutorial1 {
    private int[] arr;
    private int k;

    // Constructor
    public Tutorial1(int n, int k) {
        this.arr = new int[n];
        this.k = k;
    }

    /**
     * Algorithm 1
     * Given an array of n numbers, determine the kth largest element.
     * 1. Store numbers in an array.
     * 2. Sort the array in descending order.
     * 3. Return the number at position k.
     */
    private int Algo1(int[] arr, int k, Random rd) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing integer numbers into the array
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr[k-1];
    }

    /**
     * Algorithm 2
     * Given an array of n numbers, determine the kth largest element.
     * 1. Store the first k numbers in an array.
     * 2. Sort the array in descending order.
     * 3. For each remaining number, if the number is larger than the last number in the new array, insert the
     * number in the correct position of the array.
     * 4. Return the number at position k.
     */
    private int Algo2(int[] arr, int k, Random rd) {
        for (int i = 0; i < k; i++) {
            arr[i] = rd.nextInt(); // storing the first k numbers into the array
        }
        Arrays.sort(arr);
        for(int i = 0; i < k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;
        }
        //insertion sort
        int n = arr.length;
        for (int i = 5; i < n; i++) {
            int prev = arr[i];
            int j = i - 1;

            while (j >=0 && arr[j] > prev) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = prev;
        }
        return arr[k-1];
    }

    public static void main(String[] args) {
        // Make arrays of size 10, 10^2, 10^6 of random numbers.
        // Calculate the running time of each algorithm for each array size.

        Random rd = new Random();
        // Tutorial1 one = new Tutorial1(5,5);
        Tutorial1 ten = new Tutorial1(10, 5);
        Tutorial1 hundred = new Tutorial1(100, 5);
        Tutorial1 million = new Tutorial1(1000000, 5);

        /*
        long startTime0 = System.nanoTime();
        int k0 = one.Algo1(one.arr, one.k, rd);
        long endTime0 = System.nanoTime();
        float runTime0 = (endTime0 - startTime0);

        long startTime00 = System.nanoTime();
        int k00 = one.Algo2(one.arr, one.k, rd);
        long endTime00 = System.nanoTime();
        float runTime00 = (endTime00 - startTime00);
        */

        // Implementing algorithms for n = 10
        long startTime1 = System.nanoTime();
        int k1 = ten.Algo1(ten.arr, ten.k, rd);
        long endTime1 = System.nanoTime();
        float runTime1 = (endTime1 - startTime1);

        long startTime2 = System.nanoTime();
        int k2 = ten.Algo2(ten.arr, ten.k, rd);
        long endTime2 = System.nanoTime();
        float runTime2 = (endTime2 - startTime2);

        // Implementing algorithms for n = 100
        long startTime3 = System.nanoTime();
        int k3 = hundred.Algo1(hundred.arr, hundred.k, rd);
        long endTime3 = System.nanoTime();
        float runTime3 = (endTime3 - startTime3);

        long startTime4 = System.nanoTime();
        int k4 = hundred.Algo2(hundred.arr, hundred.k, rd);
        long endTime4 = System.nanoTime();
        float runTime4 = (endTime4 - startTime4);

        // Implementing algorithms for n = 1000000
        long startTime5 = System.nanoTime();
        int k5 = million.Algo1(million.arr, million.k, rd);
        long endTime5 = System.nanoTime();
        float runTime5 = (endTime5 - startTime5);

        long startTime6 = System.nanoTime();
        int k6 = million.Algo2(million.arr, million.k, rd);
        long endTime6 = System.nanoTime();
        float runTime6 = (endTime6 - startTime6);

        // System.out.println("run 1: " + runTime0 + " " + k0);
        // System.out.println("run 2: " + runTime00 + " " + k00);

        System.out.println("Array size 10 \n" + "Algorithm 1 Runtime: " + runTime1 + "ns" + "\nAlgorithm 1 kth Largest: " + k1);
        System.out.println("\n" + "Algorithm 2 Runtime: " + runTime2 + "ns" + "\nAlgorithm 2 kth Largest: " + k2);
        System.out.println();

        System.out.println("Array size 100 \n" + "Algorithm 1 Runtime: " + runTime3 + "ns" + "\nAlgorithm 1 kth Largest: " + k3);
        System.out.println("\n" + "Algorithm 2 Runtime: " + runTime4 + "ns" + "\nAlgorithm 2 kth Largest: " + k4);
        System.out.println();

        System.out.println("Array size 1000000 \n" + "Algorithm 1 Runtime: " + runTime5 + "ns" + "\nAlgorithm 1 kth Largest: " + k5);
        System.out.println("\n" + "Algorithm 2 Runtime: " + runTime6 + "ns" + "\nAlgorithm 2 kth Largest: " + k6);
    }
}
