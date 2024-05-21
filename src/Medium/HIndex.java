package Medium;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0, high = citations.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (citations[mid] >= mid + 1) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        new HIndex().hIndex(new int[] {3,0,6,1,5});
    }
}
