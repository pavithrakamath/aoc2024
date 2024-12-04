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

    fun count(input: Array<Array<Char>>): Int {
        var count = 0
        for (i in input.indices) {
            for (j in 0..<input[i].size) {
                //East
                if (j + 3 < input[i].size && (input[i][j] == 'X' && input[i][j + 1] == 'M' && input[i][j + 2] == 'A' && input[i][j + 3] == 'S')) {
                    println("XMAS found East at  row $i, column $j")
                    count++
                }
                //West
                if (j - 3 >= 0 && (input[i][j] == 'X' && input[i][j - 1] == 'M' && input[i][j - 2] == 'A' && input[i][j - 3] == 'S')) {
                    println("XMAS found West at row $i, column $j")
                    count++
                }
                //South
                if (i + 3 < input.size && input[i][j] == 'X' && input[i + 1][j] == 'M' && input[i + 2][j] == 'A' && input[i + 3][j] == 'S') {
                    println("XMAS found South at row $i, column $j")
                    count++
                }
                //North
                if (i - 3 >= 0 && input[i][j] == 'X' && input[i - 1][j] == 'M' && input[i - 2][j] == 'A' && input[i - 3][j] == 'S') {
                    println("XMAS found North at row $i, column $j")
                    count++
                }
                //South-east diagonal
                if (i + 3 < input.size && j + 3 < input[i].size && input[i][j] == 'X' && input[i + 1][j + 1] == 'M' && input[i + 2][j + 2] == 'A' && input[i + 3][j + 3] == 'S') {
                    println("XMAS found south east at row $i, column $j")
                    count++
                }
                // North-west diagonal
                if (i - 3 >= 0 && j - 3 >= 0 && input[i][j] == 'X' && input[i - 1][j - 1] == 'M' && input[i - 2][j - 2] == 'A' && input[i - 3][j - 3] == 'S') {
                    println("XMAS found North west at row $i, column $j")
                    count++
                }
                //South West diagonal
                if (i + 3 < input.size && j - 3 >= 0 && input[i][j] == 'X' && input[i + 1][j - 1] == 'M' && input[i + 2][j - 2] == 'A' && input[i + 3][j - 3] == 'S') {
                    println("XMAS found  South West at row $i, column $j")
                    count++
                }
                // North-east diagonal
                if (i - 3 >= 0 && j + 3 < input[i].size && input[i][j] == 'X' && input[i - 1][j + 1] == 'M' && input[i - 2][j + 2] == 'A' && input[i - 3][j + 3] == 'S') {
                    println("XMAS found at North east row $i, column $j")
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
}

