package com.a3nv.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M215KthLargestElementTest {

    private static M215KthLargestElement find;

    @BeforeAll
    static void setUp() {
        find = new M215KthLargestElement();
    }

    @Test
    public void findKthLargestNoDuplicatesInArray() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int actual = find.findKthLargest(nums, k);
        assertEquals(5, actual);
    }

    @Test
    public void findKthLargestWithDuplicatesInArray() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int actual = find.findKthLargest(nums, k);
        assertEquals(4, actual);
    }
}
