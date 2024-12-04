package com.pk.aoc.d4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class D4Test {
    @Test
    fun testCountXmas() {
        val input = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent()

        val input2 = """
            MMMSXXMASM
            MMMSXXAASM
        """.trimIndent()

        val array1 = D4().readFromFile(input.split("\n"))
        assertEquals(18, D4().count(array1))

        val array2 = D4().readFromFile(input2.split("\n"))
        assertEquals(1, D4().count(array2))

    }

}

