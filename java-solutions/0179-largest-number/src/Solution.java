import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) {
            pq.add(String.valueOf(num));
        }
        String res = "";
        while (pq.size() > 0) {
            res += pq.poll();
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }
}
