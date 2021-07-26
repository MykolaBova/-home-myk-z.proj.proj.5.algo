package org.bova.interview.functionpointer;

public class LinkNodeUtil {
        public static  ListNode constructLinkedList() {
                ListNode head = null;
                ListNode tail = null;
                for (int i = 1; i <= 5; i++) {
                        ListNode node = new ListNode(i);
                        if (head == null) {
                                head = node;
                        } else {
                                tail.setNext(node);
                        }
                        tail = node;
                }
                return head;
        }
}
