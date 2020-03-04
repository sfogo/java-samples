package com.vnet.problems;

public class ListNode {
    int value;
    ListNode next;

    ListNode(final int value) {
        this.value = value;
        this.next = null;
    }

    ListNode(final int value, final ListNode next) {
        this.value = value;
        this.next = next;
    }
}
