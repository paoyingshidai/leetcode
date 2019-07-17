package com.michael.leetcode.group2;

public class FirstBadVersion {


    /**
     * 线性扫描
     * @param n
     * @return
     */
    public int firstBadVersion1(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) return i;
        }
        return 1;
    }


    public int firstBadVersion(int n) {

        int lo = 1;
        int hi = n;

        while(lo < hi) {

            int mid = (lo + hi) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean isBadVersion(int version) {

        return false;
    }

}
