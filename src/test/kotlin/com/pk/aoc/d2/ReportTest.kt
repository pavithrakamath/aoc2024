package com.pk.aoc.d2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ReportTest {
    @Test
    fun testIsOrdered() {
        Assertions.assertTrue(Report(intArrayOf(3, 6, 8, 11, 14, 17, 19, 20)).isOrdered)
        Assertions.assertTrue(Report(intArrayOf(3, 2, 1)).isOrdered)
        Assertions.assertFalse(Report(intArrayOf(1, 3, 2)).isOrdered)
    }

    @Test
    fun testIsRightSpaced() {
        Assertions.assertTrue(Report(intArrayOf(3, 6, 8, 11, 14, 17, 19, 20)).isRightSpaced)
        Assertions.assertFalse(Report(intArrayOf(1, 4, 9)).isRightSpaced)
        Assertions.assertTrue(Report(intArrayOf(8, 6, 5, 2, 1)).isRightSpaced)
    }
}

