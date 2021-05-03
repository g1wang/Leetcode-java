package leetcode.lc202105;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0295 {
    class MedianFinder {

        Queue<Integer> small;
        Queue<Integer> large;
        boolean even ;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            small = new PriorityQueue<>((a,b)->{return b-a;});
            large = new PriorityQueue<>();
            even = true;

        }

        public void addNum(int num) {
            if(even) {
                small.offer(num);
                large.offer(small.poll());
            }else {
                large.offer(num);
                small.offer(large.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even){
                return (small.peek()+ large.peek())/2.0;
            }else return large.peek();

        }
    }
}
