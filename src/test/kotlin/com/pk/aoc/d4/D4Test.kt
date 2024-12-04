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

    @Test
    fun countMas() {
        val input = """
            MXS
            XAM
            MMS
        """.trimIndent()

        val array = D4().readFromFile(input.split("\n"))
        assertEquals(1, D4().countMas(array))

        val input2 = """
            MXS
            XAM
            XMS
            XAM
        """.trimIndent()
        val array2 = D4().readFromFile(input2.split("\n"))
        assertEquals(0, D4().countMas(array2))

        val input3 = """
            .M.S......
            ..A..MSMS.
            .M.S.MAA..
            ..A.ASMSM.
            .M.S.M....
            ..........
            S.S.S.S.S.
            .A.A.A.A..
            M.M.M.M.M.
            ..........
        """.trimIndent()
        val array3 = D4().readFromFile(input3.split("\n"))
        assertEquals(9, D4().countMas(array3))
    }
}

