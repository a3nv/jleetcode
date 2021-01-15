package com.a3nv.solutions.M973KClosestPointsToOrigin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class M973KClosesPointToOriginTest {

    private M973KClosestPointsToOrigin service;

    @BeforeEach
    public void setUp() {
        service = new M973KClosestPointsToOrigin();
    }

    /**
     * Input: points = [[1,3],[-2,2]], K = 1
     * Output: [[-2,2]]
     */
    @Test
    public void findOnePointOutOfTwo() {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        int[][] actual = service.kClosest(points, K);
        System.out.println(Arrays.toString(actual[0]));
        int[][] expected = new int[][]{{-2, 2}};
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    /**
     * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
     * Output: [[3,3],[-2,4]]
     */
    @Test
    public void findTwoOutOfThreePoints() {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        int[][] actual = service.kClosest(points, K);
        System.out.println(Arrays.toString(actual[0]) + Arrays.toString(actual[1]));
        int[][] expected = new int[][]{{3, 3}, {-2, 4}};
        assertTrue(Arrays.deepEquals(expected, actual));
    }
}
