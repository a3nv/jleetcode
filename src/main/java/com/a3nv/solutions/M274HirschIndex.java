package com.a3nv.solutions;

import static java.lang.System.out;

/**
 * 274. H-Index
 * <p>
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute
 * the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least
 * h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 * <p>
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * @see <a href="https://leetcode.com/problems/h-index/">https://leetcode.com/problems/h-index/</a>
 * @author asnv
 *         Date: August 15, 2020
 */
public class M274HirschIndex {

    public static void main(String[] args) {
        out.println(getResult(new int[]{
                5, 3, 3, 1, 0
        })); // 3
    }

    /**
     * @param publications is an array of numbers that represents number of citations for the given number of papers.
     *                     For example if the author has 3 publications it mean that param might have the following
     *                     representation [3, 1, 5]. Which means that he has 3 papers with the number of citations as
     *                     follows 3 for the first, 1 - second and finally last publication has 5 citations.
     */
    private static int getResult(int[] publications) {
        int n = publications.length;
        int[] citations = new int[n + 1];
        for (int pub : publications) {
            if (pub < n) {
                citations[pub] += 1;
            } else {
                citations[n] += 1;
            }
        }

        int total = 0;
        int i = n;
        while (i >= 0) {
            total += citations[i];
            if (total >= i) {
                return i;
            }
            i -= 1;
        }
        return i;
    }
}
