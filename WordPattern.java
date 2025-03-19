import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] words = s.split(" "); //Splitting by spaces

        System.out.println("words: " + Arrays.toString(words));

        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ca = pattern.charAt(i);
            System.out.println("char now :" + ca);

            if (map.containsKey(ca)) {
                if (!map.get(ca).equals(words[i])) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(ca, words[i]);
                set.add(words[i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaa";
        String s = "aa aa aa aa";

        System.out.println("Word matches the pattern :" + wordPattern(pattern, s));

    }
}

/**
 * Approach: A HashMap (map) is used to map each character from pattern to a corresponding word from s.
 * A HashSet (set) is used to track words that have already been mapped to ensure a one-to-one relationship.
 * TC: O(m + n)
 * SC: O(n)
 */