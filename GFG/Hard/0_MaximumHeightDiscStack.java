/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/stacking-up-discs1315/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

class Solution {
    static class Disc implements Comparable<Disc> {
        int r, h;

        public Disc(int r, int h) {
            this.r = r;
            this.h = h;
        }

        public int compareTo(Disc other) {
            if (this.r != other.r) {
                return Integer.compare(this.r, other.r);
            }
            return Integer.compare(other.h, this.h);
        }
    }

    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        Disc[] discs = new Disc[n];
        for (int i = 0; i < n; i++) {
            discs[i] = new Disc(r[i], h[i]);
        }
        Arrays.sort(discs);

        int[] uniqueH = new int[n];
        for (int i = 0; i < n; i++) {
            uniqueH[i] = h[i];
        }
        Arrays.sort(uniqueH);

        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || uniqueH[i] != uniqueH[i - 1]) {
                uniqueH[m++] = uniqueH[i];
            }
        }

        int[] bit = new int[m + 1];
        int maxTotal = 0;

        for (int i = 0; i < n; i++) {
            int hVal = discs[i].h;
            int rank = getRank(uniqueH, m, hVal);

            int currentMax = query(bit, rank - 1);
            int newMax = currentMax + hVal;

            maxTotal = Math.max(maxTotal, newMax);

            update(bit, rank, newMax);
        }

        return maxTotal;
    }

    private int getRank(int[] arr, int m, int val) {
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == val) return mid + 1;
            else if (arr[mid] < val) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private int query(int[] bit, int idx) {
        int max = 0;
        for (int i = idx; i > 0; i -= (i & -i)) {
            max = Math.max(max, bit[i]);
        }
        return max;
    }

    private void update(int[] bit, int idx, int val) {
        for (int i = idx; i < bit.length; i += (i & -i)) {
            bit[i] = Math.max(bit[i], val);
        }
    }
}
