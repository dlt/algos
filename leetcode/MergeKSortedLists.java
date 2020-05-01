/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class SortByVal implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(50, new SortByVal());

        ListNode head = new ListNode(0);
        ListNode curr = head;

        for (ListNode l : lists) {
            if (l != null)
                queue.add(l);
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();

            curr.next = new ListNode(n.val);
            curr = curr.next;

            n = n.next;

            if (n != null) {
                queue.add(n);
            }
        }

        return head.next;
    }
}