package Medium;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
    }
}

public class DoubleANumberAsALinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // creating a dummy node that points to the node to be returned
        ListNode dummy = new ListNode(-1);
        // initially assuming that head is unique value and setting it to the next one
        dummy.next = head;
        // creating another prev pointer that points to the last unique val node
        ListNode prev = dummy;
        // maintaining a key value for checking duplicates
        int key = head.val;
        // starting from the second node
        head = head.next;
        while (head != null) {
            // if condition is satisfied node is not unique so we remove it
            if (head.val == key) {
                prev.next = null;
                head = head.next;
            } else {
                // in this case either the val is not unique or we found another unique val
                key = head.val;
                // if there exists no next value then that we found no unique val in between prev and
                // this unique value. If we have a next then that was not removed in the if condition
                // and is unique so we set it as last unique value
                if (prev.next != null) prev = prev.next;
                // setting the next unique val to be next (will be removed if not unique)
                prev.next = head;
                head = head.next;
            }
        }
        // return the values that are unique
        return dummy.next;
    }gi
}
