package Medium;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DoubleANumberAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        ListNode iterator = head;
        ListNode next = head.next;
        iterator.val = iterator.val * 2;
        while (iterator.next != null) {
            int newVal = next.val * 2;
            int carry = newVal / 10;
            newVal %= 10;
            iterator.val += carry;
            next.val = newVal;
            iterator = iterator.next;
            next = next.next;
        }
        if (head.val >= 10) {
            ListNode temp = new ListNode(1, head);
            head.val = head.val % 10;
            return temp;
        }
        return head;
    }
}
