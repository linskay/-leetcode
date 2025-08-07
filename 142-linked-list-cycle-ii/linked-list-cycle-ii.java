public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodesSeen = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (nodesSeen.contains(node)) {
                return node;
            } else {
                nodesSeen.add(node);
                node = node.next;
            }
        }
        return null;
    }
}