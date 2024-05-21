package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class KthLargestElementWithoutSorting {
    private void swap(int[] ar, int i, int j) {
        int t = ar[i]; ar[i] = ar[j]; ar[j] = t;
    }

    private void heapify(int[] nums, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        int largest = i;
        if (left < n && nums[i] < nums[left]) largest = left;
        if (right < n && nums[largest] < nums[right]) largest = right;
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, n);
        }
    }

    private void makeHeap(int[] nums, int n) {
        for (int i = n - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        makeHeap(nums, n);
        Queue<Integer> cache = new LinkedList<>();
        cache.add(0);
        int steps = 0;
        while(!cache.isEmpty()) {
            int s = cache.size();
            if (k <= steps + s) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < s; i++) {
                    int curr = cache.poll();
                    max = Math.max(nums[curr], max);
                }
                return max;
            }
            for (int i = 0; i < s; i++) {
                int curr = cache.poll();
                int left = 2 * curr + 1, right = 2 * curr + 2;
                if (left < n) cache.add(left);
                if (right < n) cache.add(right);
            }
            steps += s;
        }
        return 0;
    }

    public static void main(String[] args) {
        new KthLargestElementWithoutSorting().findKthLargest(new int[]{-1, 0, 2}, 3);
    }
}
