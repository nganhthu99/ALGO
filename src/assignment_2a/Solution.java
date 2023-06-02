package assignment_2a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // Problem 1
    // A
    /*
        sum ← 0 // 1
        for i ← 0 to n-1 do // n + 1 + 1 = n + 2
            sum ← sum + 1 // 2 * n = 2n
            increment i // 2 * n = 2n

        // primitive operations: 1 + n + 2 + 2n + 2n = 5n + 3
    */

    // Problem 1
    // B
    /*
        sum ← 0 // 1
        for i ← 0 to n-1 do // n + 1 + 1 = n + 2
            for j ← 0 to n-1 do // n * (n + 2) = n^2 + 2n
                sum ← sum + 1  // 2 * n * n = 2n^2
                increment j // 2 * n * n = 2n^2
            increment i // 2 * n = 2n

        // primitive operations: 1 + n + 2 + n^2 + 2n + 2n^2 + 2n^2 + 2n = 5n^2 + 5n + 3
    */

    // Problem 2
    /*
        int[] arrays(int n) {
            int[] arr = new int[n];
            for(int i = 0; i < n; ++i){
                arr[i] = 1;
            }
            for(int i = 0; i < n; ++i) {
                for(int j = i; j < n; ++j){
                    arr[i] += arr[j] + i + j;
                }
            }
            return arr;
        }

        // asymptotic running time: O(n^2)
    */

    // Problem 3
    // A
    /*
        Algorithm merge(arr1, n1, arr2, n2)
            Input:
                array arr1 of n1 integers, sorted
                array arr2 of n2 integers, sorted
            Output:
                sorted array containing elements from arr1 and arr2
            arr <- new int[n1 + n2]
            i <- 0
            j <- 0
            index <- 0
            while i < n1 and j < n2
                if arr1[i[ < arr2[j]
                    arr[index++] = arr1[i++]
                else
                    arr[index++] = arr2[j++]
            while i < n1
                arr[index++] = arr1[i++]
            while j < n2
                arr[index++] = arr2[j++]
            return arr
    */

    // B
    /*
        // asymptotic running time: O(n)
     */

    // C
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[index++] = arr1[i++];
            } else {
                arr[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[index++] = arr2[j++];
        }
        return arr;
    }

    // Problem 4
    // A
    /*
        Algorithm removeDubs(L)
            Input: a list L
            Output: a list M containing the distinct elements of L
            M <- new list
            for i <- 0 to L.size() - 1 do
                if not M.contains(L[i]) then
                    M.add(L[i])

        // With n being the length of the input array L,
        // in the worst case, total primitive operations for running M.contains(L[i]) are approximately n * (n + 1) / 2 operations
        // which means asymptotic running time of the above algorithm is O(n^2)
    */

    // B
    /*
        Algorithm removeDubs(L)
            Input: a list L
            Output: a list M containing the distinct elements of L
            S <- new set
            for i <- 0 to L.size() - 1 do
                if not S.contains(L[i]) then
                    S.add(L[i])
            M <- new list
            for num in S do
                M.add(num)

        // With n being the length of the input array L,
        // S.contains(L[i]) will be run n times, with approximately 2 primitive operation per time
        // which means asymptotic running time of the above algorithm is O(n)
    */
    public List<Integer> removeDubs(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    // C
    /*
        I(i) = S contains distinct elements in [L[0] ... L[i]]
        Base case i = 0:
            After pass #0, S contains 1 element, L[0]
        Induction step:
            Assuming I(i) is true after pass #i, for 1 <= i < n - 1, S contains distinct elements in [L[0] ... L[i]]
            After pass #i+1, if S doesn't contain L[i + 1], L[i + 1] is added to S
            Thus, I(i + 1) is correct. Now S contains distinct elements in [L[0] ... L[i + 1]]
            This proves the claim.
     */
}
