package com.example.algorithm


// 1. TwoSum


//방법 1
class Solution {
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
class SolutionTwo {
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
class SolutionThree{
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
class SolutionFore{
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




// 2.