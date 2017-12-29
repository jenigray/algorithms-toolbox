package com.jecainteractive.greedy;

import java.util.*;

/**
 * Given n activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 */
public class ActivitySelectionProblem {

    public static void main(String[] args) {
        /**
         * Example
         *
         * Activity     A1  A2  A3  A4  A5  A6
         * Start        0   3   1   5   5   8
         * Finish       6   4   2   9   7   9
         */
        LinkedHashMap<String, int[]> activites = new LinkedHashMap<>();
        activites.put("A1", new int[]{0, 6});
        activites.put("A2", new int[]{3, 4});
        activites.put("A3", new int[]{1, 2});
        activites.put("A4", new int[]{5, 9});
        activites.put("A5", new int[]{5, 7});
        activites.put("A6", new int[]{8, 9});

        /**
         * 1. Sort the activities according to their finish time
         */
        List<Map.Entry<String, int[]>> list = new LinkedList<>(activites.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int[] a = o1.getValue();
            int[] b = o2.getValue();

            return ((Integer) a[1]).compareTo(b[1]);
        });

        System.out.println("SORTED ACTIVITIES");
        for (Map.Entry<String, int[]> activity : list) {
            int[] value = activity.getValue();
            System.out.println(activity.getKey() + " : " + value[0] + " | " + value[1]);
        }

        /**
         * 2. Select the first activity from the sorted array and print it
         */
        int count = 1;
        int currentActivityIndex = 0;
        Map.Entry<String, int[]> currentActivity = list.get(currentActivityIndex);
        int[] currentActivityValue = currentActivity.getValue();
        System.out.println("FIRST ACTIVITY");
        System.out.println(currentActivity.getKey() + " : " + currentActivityValue[0] + " - " + currentActivityValue[1]);

        /**
         * 3.Do the following for remaining activities in the sorted array
         *
         * If the start time of the activity is greater than or equal to the finish time
         * of previously selected activity then select activity and print it
         */
        System.out.println("REMAINING ACTIVITIES");
        for (int i = 1; i < list.size(); i++) {
            Map.Entry<String, int[]> activity = list.get(i);
            int[] value = activity.getValue();
            int compareResult = ((Integer) value[0]).compareTo(currentActivityValue[1]);
            if (compareResult == 1 || compareResult == 0) {
                count++;
                currentActivityIndex = i;
                currentActivity = list.get(currentActivityIndex);
                currentActivityValue = currentActivity.getValue();

                System.out.println(currentActivity.getKey() + " : " + currentActivityValue[0] + " - " + currentActivityValue[1]);
            }
        }

        System.out.println("TOTAL = " + count + " ACTIVITIES");
    }
}
