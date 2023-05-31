import assignment_2a.Solution;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(solution.mergeSortedArrays(new int[]{1, 4, 5, 8, 17}, new int[]{2, 4, 8, 11, 13, 21, 23, 25}))
        );
    }
}