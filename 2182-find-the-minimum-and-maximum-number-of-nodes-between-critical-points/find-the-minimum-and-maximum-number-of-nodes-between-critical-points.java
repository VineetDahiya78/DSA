/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();

        if (n < 3) {
            return new int[]{-1, -1};
        }

        ArrayList<Integer> critical = new ArrayList<>();

        // Find critical point indexes
        for (int i = 1; i < n - 1; i++) {

            if ((list.get(i) > list.get(i - 1) &&
                 list.get(i) > list.get(i + 1)) ||
                (list.get(i) < list.get(i - 1) &&
                 list.get(i) < list.get(i + 1))) {

                critical.add(i);
            }
        }

        if (critical.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < critical.size(); i++) {
            min = Math.min(min, critical.get(i) - critical.get(i - 1));
        }

        int max = critical.get(critical.size() - 1) - critical.get(0);

        return new int[]{min, max};
    }
}