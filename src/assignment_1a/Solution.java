package assignment_1a;

import java.util.*;

public class Solution {
    // Problem 1
    public boolean sumFound(int[] arr, int z) {
        if (arr == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(z - num) && z - num != num) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Problem 2
    public int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException();
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num <= min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin){
                secondMin = num;
            }
        }
        return secondMin;
    }

    // Problem 3
    public boolean sumFound(List<Integer> list, int k) {
        return sumFoundHelper(list, k, -1, 0);
    }

    private boolean sumFoundHelper(List<Integer> list, int k, int index, int sum) {
        if (sum > k) {
            return false;
        }
        if (sum == k) {
            return true;
        }
        for (int i = index + 1; i < list.size(); i++) {
            if (sumFoundHelper(list, k, i, sum + list.get(i))) {
                return true;
            }
        }
        return false;
    }

    // Problem 4A
    public void sort(ArrayList<Integer> list) {
        quicksort(list, 0, list.size() - 1);
    }

    private void quicksort(ArrayList<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(list, left, right);
        quicksort(list, left, p - 1);
        quicksort(list, p + 1, right);
    }

    private int partition(ArrayList<Integer> list, int left, int right) {
        int randomPos = new Random().nextInt(right - left) + left;
        swap(list, randomPos, right);
        int pivot = list.get(right);
        int i = left, j = left;
        for (; i <= right; i++) {
            if (list.get(i) <= pivot) {
                swap(list, i, j);
                j++;
            }
        }
        return j - 1;
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Problem 4B
    public void sort(LinkedList<Integer> list) {
        divide(list, 0, list.size() - 1);
    }

    private void divide(LinkedList<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        divide(list, left, mid);
        divide(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private void merge(LinkedList<Integer> list, int left, int mid, int right) {
        int[] l1 = new int[mid - left + 1];
        int[] l2 = new int[right - mid];
        for (int i = left, j = 0; i <= mid;) {
            l1[j++] = list.get(i++);
        }
        for (int i = mid + 1, j = 0; i <= right;) {
            l2[j++] = list.get(i++);
        }
        int i = 0, j = 0, index = left;
        while (i < l1.length && j < l2.length) {
            if (l1[i] < l2[j]) {
                list.set(index++, l1[i++]);
            } else {
                list.set(index++, l2[j++]);
            }
        }
        while (i < l1.length) {
            list.set(index++, l1[i++]);
        }
        while (j < l2.length) {
            list.set(index++, l2[j++]);
        }
    }

    // Problem 5A
    public boolean find(int[] arr, int z) {
        for (int num : arr) {
            if (num == z) {
                return true;
            }
        }
        return false;
    }

    // Problem 5B
    public boolean binarySearch(int[] arr, int z) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == z) {
                return true;
            }
            if (arr[mid] < z) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
