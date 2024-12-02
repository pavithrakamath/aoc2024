package com.pk.aoc.d3

import java.math.BigInteger
import java.util.regex.Pattern

class D3 {
    fun compute(input: String, initSum: BigInteger = 0.toBigInteger()): BigInteger {
        val pattern = Pattern.compile(MUL_REGEX_PATTERN)
        val matcher = pattern.matcher(input)
        var sum1 = initSum
        while (matcher.find()) {
            val firstNumber = matcher.group(1).toBigInteger()
            val secondNumber = matcher.group(2).toBigInteger()
            sum1 += firstNumber * secondNumber
        }
        return sum1
    }

    fun part1() {
        try {
            val input = D3::class.java.getResource("/D3Input.txt").readText()
            println("part 1 is ${compute(input)}")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun part2() {
        try {
            val input = D3::class.java.getResource("/D3Input.txt").readText()
            val dontRegexPattern = "\\Qdon't()\\E"

            val split = input.split(Regex(dontRegexPattern, RegexOption.MULTILINE))
            val firstBit = split[0]
            var sum = compute(firstBit)

            split.subList(1, split.size).forEach {
                val startIndex = it.indexOf("do()")
                if (startIndex > 1) {
                    val substring = it.substring(startIndex)
                    sum = compute(substring, sum)
                }
            }
            println("Part 2 is $sum")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private const val MUL_REGEX_PATTERN = "mul\\((\\d{1,3}),(\\d{1,3})\\)"

fun main() {
    D3().part1()
    D3().part2()
}




