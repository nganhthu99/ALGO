package assignment_2a;

public class Solution {
    // Problem 1A
    /*
        sum ← 0 // 1
        for i ← 0 to n-1 do // n + 1 + 1 = n + 2
            sum ← sum + 1 // 2 * n = 2n
        // primitive operations: 1 + n + 2 + 2n = 3n + 3
    */

    // Problem 1B
    /*
        sum ← 0 // 1
        for i ← 0 to n-1 do // n + 1 + 1 = n + 2
            for j ← 0 to n-1 do // n * (n + 2) = n^2 + 2n
                sum ← sum + 1  // n * n * 2 = 2n^2
        // primitive operations: 1 + n + 2 + n^2 + 2n + 2n^2 = 3n^2 + 3n + 3
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
        // asymptotic running time: O(n)
    */
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
    /*
        Algorithm removeDubs(L)
        Input: a list L
        Output: a list M containing the distinct elements of L
        M <- new list
        for i <- 0 to L.size() - 1 do // n + 2
            if not M.contains(L[i]) then // worst case: n * (n + 1) / 2
                M.add(L[i])
        // Say n is L.size(), in the worst case, operation M.contains(L[i]) will be run n * (n + 1) / 2 times
        // which means asymptotic running time of the above algorithm is O(n^2)
    */

}
