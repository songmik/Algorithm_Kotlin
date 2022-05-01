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

// 53. Maximum Subarray
class Solution_number53 {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var current = 0
        nums.forEach {
            current = maxOf(current + it, it)
            max = maxOf(max, current)
        }
        return max
    }
}

// 58. Length of Last Word
class Solution_number58 {
    fun lengthOfLastWord(s: String): Int {
        if (s.isEmpty()) return 0
        var i = s.length -1
        var sum = 0
        while(i >= 0){
            if (s[i] != ' ') sum++
            if (s[i] == ' ' && sum != 0) break
            i--
        }
        return sum
    }
}

// 66. Plus One
class Solution_number66 {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size -1 downTo 0) {
            digits[i] += 1
            if (digits[i] <= 9) return digits
            digits[i] = 0
        }
        var arr = IntArray(digits.size +1)
        arr[0] = 1

        return arr
    }
}

// 67. Add Binary
class Solution_number67 {
    fun addBinary(a: String, b: String): String {
        val target = StringBuilder()
        var aLast = a.lastIndex
        var bLast = b.lastIndex
        var sum = 0

        while(aLast >= 0 || bLast >= 0){
            if (aLast >= 0) sum += a[aLast--] - '0'
            if (bLast >= 0) sum += b[bLast--] - '0'
            if (sum >1) {
                target.append(sum % 2)
            } else {
                target.append(sum)
            }
            sum /= 2
        }
        if (sum!=0) {
            target.append(sum)
        }
        return target.toString().reversed()
    }
}

//69. Sqrt(x)
class Solution_number69 {
    fun mySqrt(x: Int): Int {
        if (x<2) return x

        var left = 2
        var right = x /2

        while(left <= right) {
            var mid = left + ( right - left ) / 2
            var squareMid: Long = mid.toLong() * mid.toLong()
            if (squareMid > x) right = mid -1
            else if (squareMid < x) left = mid + 1
            else return mid
        }
        return right
    }
}


// 70. Climbing Stairs
class Solution_number70 {
    fun climbStairs(n: Int): Int {
        val dp = Array<Int>(n +1) { 0 }
        dp.forEachIndexed() {index, _ ->
            when(index){
                0 -> dp[index] = 0
                1 -> dp[index] = 1
                2 -> dp[index] = 2
                else -> dp[index] = dp[index -1] + dp[index -2]
            }
        }
        return dp[n]
    }
}


// 83. Remove Duplicates from Sorted List
class Solution_number83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var list = head
        val result = list
        while (list!=null){
            if (list.next?.`val` == list.`val`) {
                list.next = list.next?.next
                continue
            }
            list = list.next
        }
        return result
    }
}


// 88. Merge Sorted Array
class Solution_number88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var idx1 = m - 1
        var idx2 = n -1
        var idx = m + n -1

        while(idx >= 0) {
            val num1 = if (idx1 < 0) Int.MIN_VALUE else nums1[idx1]
            var num2 = if (idx2 < 0) Int.MIN_VALUE else nums2[idx2]

            num1[idx] = if (num1 < num2 ){
                --idx1
                num1
            }
            --idx
        }
    }
}


// 94. Binary Tree Inorder Traversal
class Solution_number94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        var stack = Stack<TreeNode>()
        var outList = mutableListOf<Int>()

        if (root == null) return outList

        var currNode = root
        while(currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode)
                currNode = currNode.left
            }
            currNode = stack.pop()
            outList.add(currNode.`val`)
            currNode = currNode.right
        }
        return outList
    }
}


// 100. Same Tree
class Solution_number100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}


// 101. Symmetric Tree
class Solution_number101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null)  { return true }
        return isSubtreeSymmetric(root.left, root.right)
    }

    private fun isSubtreeSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null ){
            return true
        }
        if (left?.`val` != right?.`val`){
            return false
        }
        return isSubtreeSymmetric(left?.lefe, right?.right) && isSubtreeSymmetric(left?.right, right?.left)
    }
}

// 104. Maximum Depth of Binary Tree
class Solution_number104 {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else maxOf(maxDepth(root!!.left), maxDepth(root!!.right)) + 1
    }
}

// 108. Convert Sorted Array to Binary Search Tree
class Solution_number108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.size == 0) return null

        return sortedArrayToBSTHelper(nums, 0, nums.lastIndex)
    }

    fun sortedArrayToBSTHelper(nums: IntArray,  low: Int, high: Int) : TreeNode? {
        if (low > high) {
            return null
        }

        val mid = (low + high) / 2
        return TreeNode(nums[mid]).apply {
            left = sortedArrayToBSTHelper(nums, low, mid -1)
            right = sortedArrayToBSTHelper(nums, mid +1, high)
        }
    }
}