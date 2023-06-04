package assignment_2b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // Problem 5
    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    // A
    /*
        Best case scenario: ascending sorted array
        Worst case scenario: descending sorted array
    */

    // B
    /*
        With n being the length of the input array
        Best case running time: O(n^2)
        Worst case running time: O(n^2)
     */

    // C
    public int[] bubbleSort2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            boolean isSorted = true;
            for (int j = 0; j < len - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return arr;
            }
        }
        return arr;
    }
    public int[] bubbleSort3(int[] arr) {
        int len = arr.length;
        boolean isSortedInPrevRun = true;
        while (isSortedInPrevRun) {
            isSortedInPrevRun = false;
            for (int i = 0; i < len; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSortedInPrevRun = true;
                }
            }
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // D
    /*
        I(i) = [arr[n - i - 1], arr[n - 1]] is in final sorted order
        Base case i = 0:
            After pass #0, arr[n - 1] is in final sorted order, it is the largest element in the array
        Induction step:
            Assuming I(i) is true after pass #i, for 1 <= i < n - 1, [arr[n - i - 1], arr[n - 1]] is in final sorted order
            After pass #i+1, arr[n - i - 2] is put in correct sorted order.
            Thus, I(i + 1) is correct. [arr[n - (i + 1) - 1], arr[n - 1]] is in final sorted order
            This proves the claim.
     */

    // E
    /*
        Suppose A is an input array of distinct integers,
        i<j, and A[i] > A[j] (in other words, (A[i], A[j]) is an inversion in A).
        Suppose X is an integer between A[i] and A[j], A[i] X A[j], there are 2 cases:
            X < A[i]
                Step 1: A[i] and X will swap places with each other, resulting in X A[i] A[j]
                Step 2: A[i] and A[j] will swap places with each other
            X > A[i]
                Step 1: X and A[j] will swap places with each other, resulting in A[i] A[j] X
                Step 2: A[i] and A[j] will swap places with each other
        In conclusion, at some point, bubble sort will perform a comparison of A[i] and A[j] and then will swap A[i], A[j]
        Hence, bubble sort is an inversion-bound sorting algorithm.
     */
    // inversion-bound algorithm will produce at least as many comparisons as many inversions in the input array
    // not inversion-bound algorithm, they perform fewer comparisons than the inversions

    // Problem 6
    public int[] sort(int[] arr) {
        int LENGTH = 3;
        int[] count = new int[LENGTH];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 0, index = 0; i < LENGTH; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
        return arr;
    }
}
