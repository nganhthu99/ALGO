package assignment_1b;

import java.util.*;

public class Solution {
    // Problem 6
    public List<Set<Integer>> powerSet(List<Integer> list) {
        List<Set<Integer>> listOfSet = new ArrayList<>();
        powerSetHelper(list, -1, new HashSet<>(), listOfSet);
        return listOfSet;
    }

    private void powerSetHelper(List<Integer> list, int index, Set<Integer> set, List<Set<Integer>> listOfSet) {
        listOfSet.add(new HashSet<>(set));
        for (int i = index + 1; i < list.size(); i++) {
            set.add(list.get(i));
            powerSetHelper(list, i, set, listOfSet);
            set.remove(list.get(i));
        }
    }

    // Problem 7
    public int generate(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a0 = 0;
        int a1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a0;
            a0 = a1;
            a1 += temp;
        }
        return a1;
    }

    // Problem 8
    public int smallestCommon(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    private int gcd(int x, int y) {
        if (x < y) {
            return gcd(y, x);
        }
        if (x % y == 0) {
            return y;
        }
        return gcd(x, x % y);
    }
}
