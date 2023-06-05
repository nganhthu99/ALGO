package assignment_3a;

import java.util.Arrays;

public class Solution {
    // Problem 2
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Problem 3
    public boolean func(int m, int n) {
        int gcd = gcd(m, n);
        while (gcd % 2 == 0) {
            gcd /= 2;
        }
        return isPrime(gcd);
    }

    private int gcd(int m, int n) {
        if (m < n) return gcd(n, m);
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    // Problem 4
    public int[] mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
        return arr;
    }

    private void divide(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (right - left) / 2 + left;
        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] l1 = Arrays.copyOfRange(arr, left, mid + 1);
        int[] l2 = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, index = left;
        while (i < l1.length && j < l2.length) {
            arr[index++] = l1[i] < l2[j] ? l1[i++] : l2[j++];
        }
        while (i < l1.length) {
            arr[index++] = l1[i++];
        }
        while (j < l2.length) {
            arr[index++] = l2[j++];
        }
    }
    /*
    Running time:O(nlogn)
     */
}
