package com.pk.aoc.d1

import java.io.BufferedReader
import java.io.FileReader
import kotlin.math.abs

object D1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val firstList: MutableList<Int> = ArrayList()
        val secondList: MutableList<Int> = ArrayList()

        try {
            BufferedReader(FileReader("src/main/resources/input.txt")).use { br ->
                var line = br.readLine()
                while (line != null) {
                    firstList.add(line.split(" {3}".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0].toInt())
                    secondList.add(line.split(" {3}".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()[1].toInt())
                    line = br.readLine()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Error reading file")
        }
        p1Aoc(firstList, secondList)
        p2Aoc(firstList, secondList)
    }

    private fun p2Aoc(firstList: List<Int>, secondList: List<Int>) {
        println(similarityScore(firstList, secondList))
    }

    private fun p1Aoc(firstList: List<Int>, secondList: List<Int>) {
        val first = firstList.sorted().toIntArray()
        val second = secondList.sorted().toIntArray()
        println(distanceBetweenLists(first, second))
    }

    fun similarityScore(firstList: List<Int>, secondList: List<Int>): Int {
        val frequencyMap: MutableMap<Int, Int> = HashMap()
        for (i in secondList.indices) {
            frequencyMap[secondList[i]] = frequencyMap.getOrDefault(secondList[i], 0) + 1
        }
        var similarityScore = 0
        firstList.forEach { num: Int ->
            similarityScore += (num * frequencyMap.getOrDefault(num, 0))
        }
        return similarityScore
    }

    fun distanceBetweenLists(list1: IntArray, list2: IntArray): Int {
        var distance = 0
        for (i in list1.indices) {
            distance += abs(list1[i] - list2[i])
        }
        return distance
    }
}