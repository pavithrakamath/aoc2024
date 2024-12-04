package com.pk.aoc.d4

class D4 {

    /**
     * Reads the input from the file and converts it into a 2D array of characters.
     *
     * @param lines list of strings
     * @return 2D array of characters
     */
    fun readFromFile(lines: List<String>): Array<Array<Char>> {

        val result = Array(lines.size) { Array(lines[0].length) { ' ' } }
        for (i in lines.indices) {
            for (j in lines[i].indices) {
                result[i][j] = lines[i][j]
            }
        }
        return result
    }

    /**
     * Counts occurrences of "XMAS" in the 2D array in all directions: horizontal, vertical, diagonal, and their reverses.
     *
     * @param input 2D array of characters
     * @return the count of "XMAS" occurrences
     */
    fun count(input: Array<Array<Char>>): Int {
        var count = 0
        val directions = listOf(
            Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0), // East, West, South, North
            Pair(1, 1), Pair(-1, -1), Pair(1, -1), Pair(-1, 1) // South-east, North-west, South-west, North-east
        )
        for (i in input.indices) {
            for (j in input[i].indices) {
                for ((di, dj) in directions) {
                    if (isXmas(input, i, j, di, dj)) {
                        count++
                    }
                }
            }
        }
        println(count)
        return count
    }

    /**
     * Checks if "XMAS" is found starting from (i, j) in the direction (di, dj).
     *
     * @param input 2D array of characters
     * @param i starting row index
     * @param j starting column index
     * @param di row direction increment
     * @param dj column direction increment
     * @return true if "XMAS" is found, false otherwise
     */
    private fun isXmas(input: Array<Array<Char>>, i: Int, j: Int, di: Int, dj: Int): Boolean {
        for (k in 0..3) {
            val ni = i + k * di
            val nj = j + k * dj
            if (ni !in input.indices || nj !in input[ni].indices || input[ni][nj] != "XMAS"[k]) {
                return false
            }
        }
        return true
    }

    /**
     * Counts occurrences of "MAS" in the 2D array in all directions: horizontal, vertical, diagonal, and their reverses.
     * @param input 2D array of characters
     */
    fun countMas(input: Array<Array<Char>>): Int {
        var count = 0
        if (input.size < 3 || input[0].size < 3) {
            return 0
        }
        for (i in 1 until input.size - 1) {
            for (j in 1 until input[i].size - 1) {
                val center = input[i][j]
                val topLeft = input[i - 1][j - 1]
                val topRight = input[i - 1][j + 1]
                val bottomLeft = input[i + 1][j - 1]
                val bottomRight = input[i + 1][j + 1]

                if (center == 'A') {
                    if ((topLeft == 'M' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'S') ||
                        (topLeft == 'S' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'M') ||
                        (topLeft == 'M' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'S') ||
                        (topLeft == 'S' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'M')
                    ) {
                        count++
                    }
                }
            }
        }
        println(count)
        return count
    }

}

fun main() {
    val lines = D4::class.java.getResource("/D4Input.txt").readText().split("\n")
    val input = D4().readFromFile(lines)

    D4().count(input)
    D4().countMas(input)
}

