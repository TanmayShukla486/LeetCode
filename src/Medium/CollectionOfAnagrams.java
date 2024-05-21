package Medium;

import java.util.*;

public class CollectionOfAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each word in the input array
        for (String str: strs) {
            // Convert the current word to a character array
            char[] ar = str.toCharArray();

            // Sort the characters in the word alphabetically
            Arrays.sort(ar);

            // Convert the sorted character array back to a string
            String sorted = new String(ar);

            // Check if the sorted string is already a key in the map
            if (map.containsKey(sorted)) {
                // If it is, add the original unsorted word to the corresponding list
                map.get(sorted).add(str);
            } else {
                // If it's not, create a new list and add the original unsorted word to it
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(str);
            }
        }

        // Return a new ArrayList containing all the values (lists of anagrams) in the map
        return new ArrayList<>(map.values());
    }

}
