package Medium;

import java.util.*;

public class MinAnagramSize {
    private boolean isAnagram(String s, int subSize) {
        char[][] substrings = new char[s.length() / subSize][subSize];
        int k = 0;
        for (int i = 0; i < s.length(); i += subSize) {
            if (i + subSize <= s.length()) {
                substrings[k++] = s.substring(i, i + subSize).toCharArray();
            }
        }
        for (int i = 0; i < substrings.length; i++) Arrays.sort(substrings[i]);
        for (int i = 0; i < substrings.length - 1; i++) if (!(new String(substrings[i]).equals(new String(substrings[i + 1])))) return false;
        return true;
    }

    public int minAnagramLength(String s) {
        Map<Character, Integer> ans = new HashMap<>();
        for (char c: s.toCharArray()) {
            ans.put(c, ans.getOrDefault(c, 0) + 1);
        }
        int minSize = ans.size();
        if (minSize == s.length()) return minSize;
        List<Integer> possValues = new ArrayList<>();
        for (int i = minSize; i <= s.length(); i++)
            if (s.length() % i == 0) possValues.add(i);
        for (int val: possValues) {
            if (isAnagram(s, val)) {
                return val;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        new MinAnagramSize().minAnagramLength("pqqppqpqpq");
    }
}
