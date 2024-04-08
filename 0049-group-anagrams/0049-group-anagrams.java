import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Counting sort to sort characters
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Convert sorted character counts back to string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < charCount[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }
            String sortedStr = sb.toString();

            // Check if the sorted string is already present in the map
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // Add the original string to the corresponding group
            map.get(sortedStr).add(str);
        }

        // Convert the map values to a list of lists
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
