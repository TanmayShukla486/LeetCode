package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                hashMap.compute(nums[i][j], (key,val) -> val == null ? 1: ++val);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int key: hashMap.keySet()) {
            if (hashMap.get(key) == nums.length) answer.add(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        new IntersectionOfMultipleArrays().intersection(new int[][] {{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}});
    }
}
