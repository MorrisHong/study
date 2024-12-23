package kr.gracelove.binary_search

import kotlin.math.floor

class BinarySearch {
    fun binarySearch(list: List<Int>, target: Int): Int {
        var indexHigh = list.size - 1
        var indexLow = 0

        while (indexLow <= indexHigh) {
            println("while loop")
            val indexMid = floor((indexLow + indexHigh) / 2.0).toInt()
            val midValue = list[indexMid]

            when {
                midValue == target -> {
                    println("Found the target at index $indexMid")
                    return indexMid
                }
                midValue < target -> {
                    indexLow = indexMid + 1
                }
                else -> {
                    indexHigh = indexMid - 1
                }
            }
        }

        return -1
    }
}