package Medium;

import java.util.HashMap;
import java.util.Map;

public class KPeriodicString {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> freq = new HashMap<>();
        int max = 0;
        for (int i = 0; i < word.length(); i+=k) {
            if (i + k <= word.length()) {
                String current = word.substring(i, i + k);
                freq.put(current, freq.getOrDefault(current, 0) + 1);
                max = Math.max(max, freq.get(current));
            }
        }
        return word.length() / k - max;
    }

    public static void main(String[] args) {
        new KPeriodicString().minimumOperationsToMakeKPeriodic("leetcodeleet", 4);
    }
}
