import javafx.util.Pair;

import java.util.*;

/**
 * @author sichu huang
 * @date 2024/05/11
 **/
public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair<Double, Integer>> ratio = new ArrayList<>();
        int n = quality.length, qualitySum = 0;
        double res = Double.MAX_VALUE, maxRate = 0.0;

        for (int i = 0; i < n; ++i) {
            ratio.add(new Pair<>((double)wage[i] / quality[i], i));
        }

        ratio.sort(Comparator.comparingDouble(Pair::getKey));
        for (int i = 0; i < k; ++i) {
            qualitySum += quality[ratio.get(i).getValue()];
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            maxheap.offer(quality[ratio.get(i).getValue()]);
        }

        res = maxRate * qualitySum;
        for (int i = k; i < n; ++i) {
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            qualitySum -= maxheap.poll();
            qualitySum += quality[ratio.get(i).getValue()];
            maxheap.offer(quality[ratio.get(i).getValue()]);
            res = Math.min(res, maxRate * qualitySum);
        }
        return res;
    }
}