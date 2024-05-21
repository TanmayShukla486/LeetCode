package Hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Integer> cache = new PriorityQueue<>((a,b) -> Integer.compare(quality[b], quality[a]));
        List<Integer> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) cache.add(i);
        while (k-- > 0) {
            workers.add(cache.poll());
        }
        int den = workers.get(workers.size() - 1);
        int sal = wage[den];
        int qual = quality[den];
        double paymentInd = sal * 1.0 / qual;
        double cost = 0.0;
        for (int ind: workers) {
            cost += quality[ind] * paymentInd;
        }
        return cost;
    }

    public static void main(String[] args) {
        new MinimumCostToHireKWorkers().mincostToHireWorkers(
                new int[] {10,20,5}, new int[] {70,50,30}, 2
        );
    }
}
