package com.a3nv.solutions;

/**
 * Find the Kth largest element in an unsorted array. Note that it is the Kth largest element in the sorted order, not
 * the Kth distinct element.
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * Suggestions: The brute force solution is just sort an array in O(n * logn) time, and then iterate over sorted array
 * picking Kth element (in that case most likely optimal way is to iterate backwards).
 * @author Ivan Asonov
 *         Date: January 04, 2021
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an
 *         Array</a>
 */
public class M215KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        naiveQuickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void naiveQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            naiveQuickSort(array, low, pivot - 1);
            naiveQuickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // pick the last element as a pivot
        int i = low - 1; // index of a smaller element
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // swap array[i] and array[j]
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
