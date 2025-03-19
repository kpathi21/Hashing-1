import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Approach 2 - TC: O(n*k), SC: O(n)
public class GroupAnagrams2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        HashMap<Double, List<String>> map = new HashMap<>();

        for (String s : strs) {
            double hash = getHash(s); // O(k)

            if (!map.containsKey(hash)) { // O(1)
                map.put(hash, new ArrayList<>());
            }

            map.get(hash).add(s); // O(1)

        }

        return new ArrayList<>(map.values());
    }

    private double getHash(String str) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        double hash = 1;

        for (char c : str.toCharArray()) { //abt
            hash = hash * primes[c - 'a']; //primes[0] -> 97 -97 (ascii)
        }
        return hash;
    }
}
