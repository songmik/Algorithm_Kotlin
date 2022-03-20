package com.example.algorithm

//카로 Kotlin Test

//class Solution{
//    fun addTwoNumbers(l1:ListNode?, l2:ListNode?):ListNode?
//    {
//        val head = ListNode(0)
//        var current = head
//        var node1 = l1
//        var node2 = l2
//        var carry = 0
//
//
//        while(node1 != null || node2 != null || carry>0) {
//            val new1 = node1?.'val' ?: 0
//            val new2 = node2?.'val' ?: 0
//            val sum = (new1 + new2 + carry) % 10
//            carry = (new1 + new2 + carry) / 10
//            current?.next = ListNode(sum)
//            current = current?.next
//
//            if (node1 != null) node1 = node1.next
//            if (node2 != null) node2 = node2.next
//        }
//        return head.next
//
//    }
//}