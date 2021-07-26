package org.bova.interview.functionpointer;

import org.junit.jupiter.api.Test;

import static org.bova.interview.functionpointer.LinkNodeUtil.constructLinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SingleLinkedListReverserTest {


        @Test
        public void givenLinkedList_whenconstructLinkedList() {
                ListNode head = constructLinkedList();

                assertEquals(1, head.getData());
        }

        @Test
        public void givenLinkedList_whenIterativeReverse_thenOutputCorrectResult() {
                ListNode head = constructLinkedList();
                ListNode node = head;
                for (int i = 1; i <= 5; i++) {
                        assertNotNull(node);
                        assertEquals(i, node.getData());
                        node = node.getNext();
                }
                SingleLinkedListReverser reverser = new SingleLinkedListReverser();
                node = reverser.reverseList(head);
                for (int i = 5; i >= 1; i--) {
                        assertNotNull(node);
                        assertEquals(i, node.getData());
                        node = node.getNext();
                }
        }

        @Test
        public void givenLinkedList_whenRecursiveReverse_thenOutputCorrectResult() {
                ListNode head = constructLinkedList();
                ListNode node = head;
                for (int i = 1; i <= 5; i++) {
                        assertNotNull(node);
                        assertEquals(i, node.getData());
                        node = node.getNext();
                }
                SingleLinkedListReverser reverser = new SingleLinkedListReverser();
                node = reverser.reverseListRecursive(head);
                for (int i = 5; i >= 1; i--) {
                        assertNotNull(node);
                        assertEquals(i, node.getData());
                        node = node.getNext();
                }
        }
}
