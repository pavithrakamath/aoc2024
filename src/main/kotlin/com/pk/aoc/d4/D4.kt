package com.pk.aoc.d4

class D4 {

//read file D4Input.txt into a 2-dimensional array or size [140][140] each element is an english letter

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

    fun countMas(input: Array<Array<Char>>): Int {
        var count = 0
        for (i in input.indices) {
            for (j in 0..<input[i].size) {/* """
                    MAS
                    .A.
                    MAS
                """*/
                if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < input.size && j + 1 < input[i].size && input[i][j] == 'A' && input[i + 1][j + 1] == 'S' && input[i - 1][j + 1] == 'S' && input[i + 1][j - 1] == 'M' && input[i - 1][j - 1] == 'M') {
                    println("MAS found at row $i, column $j")
                    count++
                }/* """
                  SAM
                  .A.
                  SAM
              """*/
                else if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < input.size && j + 1 < input[i].size && input[i][j] == 'A' && input[i + 1][j + 1] == 'M' && input[i - 1][j + 1] == 'M' && input[i + 1][j - 1] == 'S' && input[i - 1][j - 1] == 'S') {
                    println("MAS found at row $i, column $j")
                    count++
                }/* """
                  MAM
                  .A.
                  SAS
              """*/
                else if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < input.size && j + 1 < input[i].size && input[i][j] == 'A' && input[i + 1][j + 1] == 'S' && input[i - 1][j + 1] == 'M' && input[i + 1][j - 1] == 'S' && input[i - 1][j - 1] == 'M') {
                    println("MAS found at row $i, column $j")
                    count++
                }/* """
                  SAS
                  .A.
                  MAM
              """*/
                else if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < input.size && j + 1 < input[i].size && input[i][j] == 'A' && input[i + 1][j + 1] == 'M' && input[i - 1][j + 1] == 'S' && input[i + 1][j - 1] == 'M' && input[i - 1][j - 1] == 'S') {
                    println("MAS found at row $i, column $j")
                    count++
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

    // count for XMAS in the 2D array can be diagonal, horizontal, vertical, reverse diagonal, reverse horizontal, reverse vertical
    D4().count(input)
    D4().countMas(input)
}

