package com.example.algorithm

import java.util.*


// 1. TwoSum


//방법 1
class Solution_number1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            map[int]?.let { return intArrayOf(it, index) }
            map[target - int] = index
        }
        return intArrayOf()
    }
}

//방법 2
class SolutionTwo_number1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val com = target - num
            val other = map.get(com)
            when {
                other != null -> return intArrayOf(other, index)
                else -> map[num] = index
            }
        }
        return IntArray(2)
    }
}

// 방법 3
class SolutionThree_number1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()
        nums.forEachIndexed { index, number ->
            val compliement = target - number
            if (map.containsKey(compliement)) return intArrayOf(map[compliement]!!, index)
            map[number] = index
        }
        throw IllegalArgumentException("No two sum solution")
    }
}


//방법 4
class SolutionFore_number1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val goal = target - i
            if (map[goal] != null) return intArrayOf(map[goal]!!, index)
            map[i] = index
        }
        return intArrayOf(-1, -1)
    }
}


// 9. Pallindrome Number
class Solution_number9 {
    fun isPalindrome(x: Int): Boolean =
        x.toString().let { it == it.reversed() }
}




// 13. Roman to Integer
class Solution_number13 {
    fun romanToInt(s: String): Int {
        val map = mutableMapOf(
            'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
        )
        val number = 0
        val last = 1000
        s.forEach {
            val value = map[it] ?: 0
            if (value > last) number -= last * 2
            number += value
            last = value
        }
        return number
    }
}



// 14. Longest Common Prefix
class Solution_number14 {
    fun longestCommonPrefix(strs: Array<String>) = StringBuilder().apply {
        strs.minBy { it.length }?.forEachIndexed { i, c -> if (strs.all { it[i] == c }) append(c) else return toString() }
    }.toString()
}

class SolutionTwo_number14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        strs.sort()
        for (i in strs[0].indices) {
            if (strs[0][i] != strs[strs.size-1][i]) return strs[0].substring(0,i)
        }
        return strs[0]
    }
}


// 20. Valid Parentheses
class Solution_number20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.reversed().forEach {
            when(it) {
                '(' -> if (stack.isNotEmpty() && stack.peek() == ')') stack.pop() else stack.push(it)
                '[' -> if (stack.isNotEmpty() && stack.peek() == ']') stack.pop() else stack.push(it)
                '{' -> if (stack.isNotEmpty() && stack.peek() == '}') stack.pop() else stack.push(it)
                else -> stack.push(it)
            }
        }
        return stack.isEmpty()
    }
}


// 21. Merge Two Sorted Lists
class Solution_number21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val (small, large) =
            if (list1.`val` < list2.`val`)
                list1 to list2
            else
                list2 to list1

        small.next = mergeTwoLists(small.next, large)
        return small
    }
}


// 26. Remove Duplicates from Sorted Array
class Solution_number26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var lastIdx = 1
        var curVal = nums[0]

        nums.forEachIndexed { i, _ ->
            if (nums[i] > curVal) {
                curVal = nums[i]
                nums[lastIdx] = nums[i]
                lastIdx++
            }
        }
        return lastIdx
    }
}

//27. Remove Element
class Solution_number27 {
    fun removeElement(nums: IntArray, num: Int): Int {
        var counter = 0
        nums.forEach { if (it !=num) nums[counter++] = it }

        return counter
    }
}


// 28. Implement strStr()
class Solution_number28 {
    fun strStr(haystack: String, needle: String): Int {
        var check = StringBuilder()

        if (needle.isEmpty()) return 0

        for (i in haystack.indices){
            check.append(haystack[i])
            if (check.length> needle.length) {
                check.deleteCharAt(0)
            }
            if (check.toString() == needle) {
                return i-(needle.length-1)
            }
        }
        return -1
    }
}


// 35. Search Insert Position
class Solution_number35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var i = 0
        while(i < nums.size){
            if (nums[i] == target) return i
            if (i == 0 && target < nums[i]) return i
            if (i > 0 && target > nums[i-1] && target < nums[i]) return i
            i++
        }
        return i
    }
}