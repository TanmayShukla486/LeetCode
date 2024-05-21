package Easy;

public class CycleDetection {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to check if a linked list contains a cycle
    public boolean hasCycle(ListNode head) {
        // Handle the base case: empty list has no cycle
        if (head == null) return false;

        // Initialize two pointers: slow moves one step at a time, fast moves two
        ListNode slow = head;
        ListNode fast = head;

        // Loop as long as fast is not null and slow and fast haven't met
        do {
            slow = slow.next; // Slow pointer moves one step

            // Advance fast pointer two steps if possible (avoid going out of bounds)
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null; // Terminate loop if fast reaches the end
            }

            // Continue looping until fast is null or slow and fast meet
        } while (fast != null && slow != fast);

        // After the loop:
        // - If fast is null, no cycle detected (fast reached the end without meeting slow)
        // else cycle is detected
        return fast != null;

    }

}
