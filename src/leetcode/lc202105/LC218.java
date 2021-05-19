package leetcode.lc202105;

import java.util.*;

/**
 * 218. The Skyline Problem
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        //l,r,h
        int[][] lefts = new int[buildings.length][2];
        int[][] rights = new int[buildings.length][2];
        for (int i = 0; i < buildings.length; i++) {
            lefts[i][0] = buildings[i][0];
            lefts[i][1] = buildings[i][2];
            rights[i][0] = buildings[i][1];
            rights[i][1] = buildings[i][2];
        }
        Comparator<int[]> comparatorL = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        };
        Comparator<int[]> comparatorR = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        };
        Arrays.sort(lefts, comparatorL);
        Arrays.sort(rights, comparatorR);
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        //TreeMap<Integer, Integer> heightTree = new TreeMap<>();
        int leftIdx = 0, rightIdx = 0;
        //in==in, her first
        // out==out, ler first
        // in==out, in first;
        while (leftIdx < buildings.length || rightIdx < buildings.length) {
            List<Integer> list = new ArrayList<>();
            if (leftIdx < buildings.length && lefts[leftIdx][0] <= rights[rightIdx][0]) {
                if (pq.isEmpty() || pq.peek() < lefts[leftIdx][1]) {
                    list.add(lefts[leftIdx][0]);
                    list.add(lefts[leftIdx][1]);
                    ans.add(list);
                }
                pq.offer(lefts[leftIdx][1]);
                leftIdx++;
            } else {
                if (pq.peek() > rights[rightIdx][1]) pq.remove(rights[rightIdx][1]);
                else {
                    pq.poll();
                    if (pq.isEmpty()||pq.peek() < rights[rightIdx][1]) {
                        list.add(rights[rightIdx][0]);
                        list.add(pq.isEmpty()?0:pq.peek());
                        ans.add(list);
                    }
                }
                rightIdx++;
            }
        }
        return ans;
    }
}
