import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!sMap.containsKey(sChar)) {
                if (set.contains(tChar)) {
                    return false;
                }
                sMap.put(sChar, tChar);
                set.add(tChar);
            } else {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            }
        }

        return true;
    }
}

/**
 * We use a HashMap to map each character in `s` to its corresponding character in `t`, allowing for constant-time lookups.
 * Additionally, we use a HashSet to track characters from `t` that have already been mapped, ensuring no two characters from `s` map to the same `t` character.
 *
 * Time Complexity: O(n) – We traverse each character of `s` and `t` once.
 * Space Complexity: O(1) – Since we are storing at most 256 mappings (for all ASCII characters), this is considered constant space.
 */