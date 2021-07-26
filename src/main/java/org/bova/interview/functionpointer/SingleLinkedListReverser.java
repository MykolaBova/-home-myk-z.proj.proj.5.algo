package org.bova.interview.functionpointer;

public class SingleLinkedListReverser {

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        ListNode node = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }

}
