package com.a3nv.solutions.M973KClosestPointsToOrigin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 *
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 *
 * <ul>
 *     <li>1 <= K <= points.length <= 10000</li>
 *     <li>-10000 < points[i][0] < 10000</li>
 *     <li>-10000 < points[i][1] < 10000</li>
 * </ul>
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 * @author Ivan
 *         Date: January 14, 2021
 */
public class M973KClosestPointsToOrigin {

    /**
     * Two crucial points here is to find a distance between origin point and point from the array. Second, is to use
     * priority queue to organize point by their distance and then get the Ks points from that result queue;
     * @param points array with points
     * @param K      how many points we have to take
     * @return resulted array
     */
    public int[][] kClosest(int[][] points, int K) {
        // there is a constructor that accepts
        PriorityQueue<int[]> ordered = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int[] point : points) {
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            ordered.add(new int[]{distance, point[0], point[1]});
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] point = ordered.poll();
            if (point != null) {
                result[i] = new int[]{point[1], point[2]};
            }
        }
        return result;
    }
}
