package com.example.algorithm


// 1. TwoSum


//방법 1
class Solution_number1 {
    fun twoSum(nums: IntArray, target: Int) : IntArray {
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
    fun twoSum(nums: IntArray, target: Int) : IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed{ index, num ->
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
class SolutionThree_number1{
    fun twoSum(nums: IntArray, target: Int) :IntArray{
        val map : MutableMap<Int, Int> = mutableMapOf()
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
            val goal = target -i
            if (map[goal] != null) return intArrayOf(map[goal]!!, index)
            map[i] = index
        }
        return intArrayOf(-1, -1)
    }
}




// 9. Pallindrome Number
class Solution_number9 {
    fun isPalindrome(x: Int) :Boolean =
        x.toString().let{ it == it.reversed() }
}




// 13. Roman to Integer
class Solution_number13 {
    fun romanToInt(s: String) : Int {
        val map = mutableMapOf(
            'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
        )
        val number = 0
        val last = 1000
        s.forEach {
            val value = map[it] ?: 0
            if (value > last) number -= last*2
            number += value
            last = value
        }
        return number
    }
}