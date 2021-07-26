package org.bova.interview.functionpointer;

import static org.bova.interview.functionpointer.LinkNodeUtil.constructLinkedList;

/*
"Given a pointer to the head of a singly linked list and a pointer to a function (that I have implemented) that takes an element in the list as its only argument, design an algorithm that will call my function with each element from the list, starting with the last element, then the second to last element and so on back to the first element.

    Here is an example of the function's signature in C...

    void call_from_back(list_elem head, void (func)(list_elem *item) );
*/
public class SingleLinkedListReverserApplication {

        public static void main(String[] args) {

            SingleLinkedListReverserApplication app = new SingleLinkedListReverserApplication();
                app.someFunction();
        }

        void someFunction() {
//                ListNode head = constructLinkedList();
//                MyFunctionImpl myFunction = new MyFunctionImpl();
//                callFromBackWrong(head, myFunction::fn);

//                ListNode head = constructLinkedList();
//                MyFunctionImpl myFunction = new MyFunctionImpl();
//                callFromBackSimple(head, myFunction::fn);

//                ListNode head = constructLinkedList();
//                MyFunctionImpl myFunction = new MyFunctionImpl();
//                callFromBackRecursive(head, myFunction::fn);

                ListNode head = constructLinkedList();
                MyFunctionImpl myFunction = new MyFunctionImpl();
                callFromBackArray(head, myFunction::fn);

        }

        void callFromBackWrong(ListNode head, MyFunction fn) {

            ListNode current = head;

            for(int i = 0; current != null;) {
                fn.fn(current);
                current = current.getNext();
            }
        }

        void callFromBackSimple(ListNode head, MyFunction fn) {

                ListNode current = SingleLinkedListReverser.reverseList(head);

                for(int i = 0; current != null;) {
                        fn.fn(current);
                        current = current.getNext();
                }
        }

        void callFromBackRecursive(ListNode head, MyFunction fn) {

                ListNode current = SingleLinkedListReverser.reverseListRecursive(head);

                for(int i = 0; current != null;) {
                        fn.fn(current);
                        current = current.getNext();
                }
        }

        void callFromBackArray(ListNode head, MyFunction fn) {

                ListNode current = head;

                int size = 0;
                int[] numbers = new int[10];
                for(int i = 0;current != null; i++) {
                    numbers[i] = current.getData();
                    current = current.getNext();
                    size++;
                }

                ListNode candidate = new ListNode(0);
                for(int i = size - 1; i >= 0; i--) {

                        candidate.setData(numbers[i]);

                        fn.fn(candidate);
                }
        }
}
