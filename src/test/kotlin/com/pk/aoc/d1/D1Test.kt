package com.pk.aoc.d1

import com.pk.aoc.d1.D1.similarityScore
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class D1Test {
    @Test
    fun testSimilarityScore() {
        Assertions.assertEquals(0, similarityScore(listOf(1, 2, 3), listOf(4, 5, 6)))
        Assertions.assertEquals(6, similarityScore(listOf(1, 2, 3), listOf(1, 2, 3)))
        Assertions.assertEquals(31, similarityScore(listOf(3, 4, 2, 1, 3, 3), listOf(4, 3, 5, 3, 9, 3)))
    }

    @Test
    fun testDistanceBetweenLists() {
        Assertions.assertEquals(0, D1.distanceBetweenLists(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
        Assertions.assertEquals(9, D1.distanceBetweenLists(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
        Assertions.assertEquals(4, D1.distanceBetweenLists(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
    }
}