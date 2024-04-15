package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] answer = new int[people.length];

        // Creating a 2D array to store indices of people for correct order of answer
        int[][] peopleWithIndex = new int[people.length][2];
        for (int i = 0; i < people.length; i++)
            peopleWithIndex[i] = new int[] {people[i], i};
        // Sorting the people according to their arrival time
        Arrays.sort(peopleWithIndex, Comparator.comparingInt(a -> a[0]));
        // Sorting the flowers according their bloom times (according to the start and end values)
        Arrays.sort(flowers, Arrays::compare);

        // Priority Queue to hold the endTime of each flower in the sorted order
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        for (int i = 0, j = 0; i < people.length; i++) {
            int time = peopleWithIndex[i][0];
            int index = peopleWithIndex[i][1];
            // adding all the flowers that have a start time <= arrival of the ith person
            // j is constantly moving as for each person we have already stored the values
            // in the previous iterations, so we need not check again for them
            while (flowers[j][0] <= time)
                endTimes.add(flowers[j++][1]);
            // removing all the flowers whose end time is less than the arrival time of the person
            while (!endTimes.isEmpty() && endTimes.peek() < time) endTimes.poll();
            // After addition and removal of flowers the priority queue contains all the flowers
            // that a person will see in bloom when he arrives, so we store it in answer array
            answer[index] = endTimes.size();
        }
        return answer;
    }

}
