package wc.wc258;

import java.util.HashMap;
import java.util.Map;

public class LC5868 {
    public long interchangeableRectangles(int[][] rectangles) {

        Map<Float, Integer> map = new HashMap<>();
        long ans = 0;
        for (int[] rectangle : rectangles) {
            float ratio = (float) (rectangle[0] / (rectangle[1] * 1.0));
            int count = map.getOrDefault(ratio, 0);
            ans += count;
            map.put(ratio, count + 1);
        }
        return ans;

    }
}
