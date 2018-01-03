package com.jecainteractive.sorting;

public class Quicksort {

    public static void main(String[] args) {
        int[] arrValues = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        quickSort(arrValues, 0, arrValues.length);
    }

    public static int[] quickSort(int[] arrValues, int startIndex, int endIndex) {
        if(startIndex >= endIndex)
            return arrValues;

        int partitionIndex = partition(arrValues, startIndex, endIndex);
        System.out.print("\nPARTITION INDEX: " + partitionIndex);
        arrValues = quickSort(arrValues, startIndex, partitionIndex - 1);
        System.out.print("\nLEFT QUICK SORT: ");
        for (int value : arrValues) {
            System.out.print(value + " ");
        }
        arrValues = quickSort(arrValues, partitionIndex, endIndex);
        System.out.print("\nRIGHT QUICK SORT: ");
        for (int value : arrValues) {
            System.out.print(value + " ");
        }

        return arrValues;
    }

    public static void randomizedPivotValue() {

    }

    public static int partition(int[] arrValues, int startIndex, int endIndex) {
        // 1. Pivot Criteria: Select the last element as pivot value (This is what I want)
        int pivotValue = arrValues[endIndex - 1];

        System.out.println("\nPIVOT VALUE: " + pivotValue);

        // Assign the partitionIndex as the startIndex
        int partitionIndex = startIndex;

        System.out.print("O: ");
        for (int value : arrValues) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 2. Partition
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println();
            if (arrValues[i] <= pivotValue) {
                System.out.print("O: ");
                for (int value : arrValues) {
                    System.out.print(value + " ");
                }
                System.out.println(" | i = " + i + " | " + "partitionIndex = " + partitionIndex);

                // Swap values
                int temp = arrValues[partitionIndex];
                arrValues[partitionIndex] = arrValues[i];
                arrValues[i] = temp;

                partitionIndex++; // Searching for the pivotIndex

                System.out.print("C: ");
                for (int value : arrValues) {
                    System.out.print(value + " ");
                }
            } else {
                System.out.print("O: ");
                for (int value : arrValues) {
                    System.out.print(value + " ");
                }
            }

            System.out.print(" | i = " + i + " | " + "partitionIndex = " + partitionIndex);
        }

        return partitionIndex;
    }
}