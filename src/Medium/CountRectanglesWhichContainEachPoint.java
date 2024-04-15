package Medium;

import java.util.*;



public class CountRectanglesWhichContainEachPoint {



    /**Binary Search function to find the smallest length of rectangle
     * greater than or equal to x so as all the ones after it would be able
     * to enclose x in them*/
    private int binarySearch(List<Integer> lengths, int x) {
        int answer = lengths.size();
        int low = 0, high = answer - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (lengths.get(mid) >= x) {
                answer = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return answer;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        // Storing all the rectangles in the hashmap in the form of key and value where:
        // key => height of the rectangle
        // value => list of all x's that have a height = y
        for (int[] rectangle : rectangles) {
            if (hashMap.containsKey(rectangle[1])) hashMap.get(rectangle[1]).add(rectangle[0]);
            else {
                hashMap.put(rectangle[1], new ArrayList<>());
                hashMap.get(rectangle[1]).add(rectangle[0]);
            }
        }
        // Sorting all the x values at each key
        for (int i: hashMap.keySet()) {
            Collections.sort(hashMap.get(i));
        }

        int[] answer = new int[points.length];
        // iterating through the points
        for (int i = 0; i < points.length; i++) {
            int y = points[i][1], x = points[i][0];
            // starting from the height of the point and finding all rectangles with width >= x
            for (int j = y; j <= 100; j++) {
                if (hashMap.containsKey(j)) {
                    answer[i] += hashMap.get(j).size() - binarySearch(hashMap.get(j), x);
                }
            }
        }
        return answer;
    }
}
