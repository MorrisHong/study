package binary_search

import kr.gracelove.binary_search.BinarySearch
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTest {

    @Test
    fun `binary search test`() {
        val binarySearch = BinarySearch()
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 10

        val result = binarySearch.binarySearch(list, target)
    }
}