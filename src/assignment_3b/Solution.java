package assignment_3b;

import java.util.*;

public class Solution {
    // Problem 3
    public List<Integer> reverseArray(List<Integer> list) {
        return reverseArrayHelper(list, 0);
    }

    private List<Integer> reverseArrayHelper(List<Integer> list, int left) {
        if (left == list.size() / 2 + 1) return list;
        int right = list.size() - 1 - left;
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
        reverseArrayHelper(list, left + 1);
        return list;
    }
    /*
    Running time, computed by couting self-calls: O(n)
     */

    // Problem 4
    public int iterativeFib(int n) {
        if (n == 0 || n == 1) return n;
        int f1 = 0, f2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = f1;
            f1 = f2;
            f2 = temp + f1;
        }
        return f2;
    }

    public int memoizationFib(int n, int[] memoization) {
        if (n == 0 || n == 1) {
            memoization[n] = n;
        } else {
            memoization[n] = memoizationFib(n - 1, memoization) + memoizationFib(n - 2, memoization);
        }
        return memoization[n];
    }

    // Problem 5
    /*
    Does the same technique solve the corresponding ThirdSmallest problem in O(n) time?
    --> Yes, we can use the same technique to solve third smallest problem in O(n) time.

    What if "second" and "third" are replaced by "kth", where k represents any number from 2 to n1?
    For instance, is there a fast algorithm for finding the n/2-smallest element in a list of n elements?
    Is the sorting approach the fastest way in this case?
    --> Finding the kth smallest element in an array can be solved in O(n) running time by using quick-select algorithm.
     */
    public int findKthSmallestElement(int[] arr, int k) {
        return quickselect(arr, k, 0, arr.length - 1);
    }

    private int quickselect(int[] arr, int k, int left, int right) {
        int p = partition(arr, left, right);
        if (p < k - 1) return quickselect(arr, k, p + 1, right);
        if (p > k - 1) return quickselect(arr, k, left, p - 1);
        return arr[p];
    }

    private int partition(int[] arr, int left, int right) {
        int randomPos = new Random().nextInt(right - left) + left;
        swap(arr, randomPos, right);
        int pivot = arr[right];
        int i = left, j = left;
        for (; i <= right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }
        }
        return j - 1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public int maxHeap(int[] arr, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
//        for (int num : arr) {
//            heap.add(num);
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//        // nlogk
//        return heap.poll();
//    }
//
//    public int minHeap(int[] arr, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : arr) {
//            heap.add(num);
//        }
//        // nlogn + k
//        while (k-- > 1) {
//            heap.poll();
//        }
//        return heap.poll();
//    }
}
