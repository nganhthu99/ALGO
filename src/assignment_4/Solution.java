package assignment_4;

import java.util.List;
import java.util.Random;

public class Solution {
    // Problem 3
    public int[] randomArrangement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = new Random().nextInt(arr.length - i) + i;
            swap(arr, i, randomIndex);
        }
        return arr;
    }

    // Problem 6
    public int[] sidewaysSorting(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] bucket = new int[max - min + 1];
        for (int num : arr) {
            bucket[num - min]++;
        }

        for (int i = 0, index = 0; index < arr.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index] = i + min;
                index += 2;
            }
        }
        for (int i = bucket.length - 1, index = 1; index < arr.length; i--) {
            while (bucket[i]-- > 0) {
                arr[index] = i + min;
                index += 2;
            }
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
