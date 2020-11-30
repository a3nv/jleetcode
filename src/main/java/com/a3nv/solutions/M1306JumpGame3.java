package com.a3nv.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * <a href="https://leetcode.com/problems/jump-game-iii/">Jump game 3</a>
 */
public class M1306JumpGame3 {

    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            if (arr[current] == 0) {
                return true;
            }
            int left = current + arr[current];
            int right = current - arr[current];
            if (left < arr.length && !visited.contains(left)) {
                q.add(left);
                visited.add(left);
            }

            if (right >= 0 && !visited.contains(right)) {
                q.add(right);
                visited.add(right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(data, start));

        start = 0;
        System.out.println(canReach(data, start));

        data = new int[]{3, 0, 2, 1, 2};
        start = 2;
        System.out.println(canReach(data, 2));
    }
}
