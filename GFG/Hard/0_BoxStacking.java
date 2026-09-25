/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/box-stacking/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

import java.util.Arrays;

class Solution {
    static class Box implements Comparable<Box> {
        int h, w, l;

        public Box(int h, int w, int l) {
            this.h = h;
            this.w = w;
            this.l = l;
        }

        public int compareTo(Box other) {
            long thisArea = (long) this.w * this.l;
            long otherArea = (long) other.w * other.l;
            return Long.compare(otherArea, thisArea);
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        Box[] boxes = new Box[n * 3];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int h = height[i];
            int w = width[i];
            int l = length[i];

            boxes[index++] = new Box(h, Math.min(w, l), Math.max(w, l));
            boxes[index++] = new Box(w, Math.min(h, l), Math.max(h, l));
            boxes[index++] = new Box(l, Math.min(h, w), Math.max(h, w));
        }

        Arrays.sort(boxes);

        int[] msh = new int[n * 3];
        for (int i = 0; i < n * 3; i++) {
            msh[i] = boxes[i].h;
        }

        int maxResult = 0;

        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i].w < boxes[j].w && boxes[i].l < boxes[j].l) {
                    msh[i] = Math.max(msh[i], msh[j] + boxes[i].h);
                }
            }
            maxResult = Math.max(maxResult, msh[i]);
        }

        return maxResult;
    }
}
