import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            String key = String.valueOf(ca);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);

        }

        return new ArrayList<>(map.values());
    }
}

/**
 * Time Complexity: O(n (k log k)) where n is iterating through all strings and O(k log k) for sorting each word.
 * Space Complexity: O(n) where n is number of strings.
 */