package Medium;

import java.util.Stack;

public class RemoveNonLeaderNodes {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this(val, null);
        }

        public static ListNode createLinkedList(int[] ar) {
            ListNode head = new ListNode(ar[0]);
            ListNode iterator = head;
            for (int i = 1; i < ar.length; i++) {
                if (i != ar.length - 1) {
                    iterator.next = new ListNode(ar[i]);
                    iterator = iterator.next;
                } else iterator.next = new ListNode(ar[i]);
            }
            return head;
        }

        public static void display(ListNode head) {
            while (head != null) {
                System.out.print(head.val + "\t");
                head = head.next;
            }
        }
    }
    private ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode iterator = head.next;
        stack.push(head);
        while (iterator != null) {
            while (!stack.isEmpty() && stack.peek().val < iterator.val) stack.pop();
            stack.push(iterator);
            iterator = iterator.next;
        }
        ListNode nxt = null;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            curr.next = nxt;
            nxt = curr;
        }
        return nxt;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[] {
            1,1,1,1
        });
        head = new RemoveNonLeaderNodes().removeNodes(head);
        ListNode.display(head);
    }

}
