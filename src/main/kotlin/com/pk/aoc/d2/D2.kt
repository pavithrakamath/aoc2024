package com.pk.aoc.d2

import java.io.BufferedReader
import java.io.FileReader
import java.util.*
import java.util.stream.Collectors

object D2 {
    private fun safeReports(reports: List<Report>) {
        val output = p1(reports)
        println("Total safe records = " + (p2(output.first) + output.second))
    }

    private fun p2(reports: List<Report>): Int {
        var count = 0
        reports.forEach { report: Report ->
            val subReports: MutableList<Report> = ArrayList()
            for (i in report.levels.indices) {
                val levels = report.levels.toMutableList()
                levels.removeAt(i)
                subReports.add(Report(levels.toIntArray()))
            }
            if (subReports.any { r: Report -> r.isOrdered && r.isRightSpaced }) {
                count++
            }
        }
        println("Tolerated Reports: $count")
        return count

    }

    private fun p1(reports: List<Report>): Pair<List<Report>, Int> {
        val unsafe: MutableList<Report> = ArrayList()
        var count = 0
        reports.forEach { report: Report ->
            if (report.isOrdered && report.isRightSpaced) {
                count++
            } else {
                unsafe.add(report)
            }
        }
        println("Safe Reports round 1: $count")
        return Pair(unsafe, count)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            BufferedReader(FileReader("src/main/resources/D2Input.txt")).use { br ->
                val reports = br.lines().map { line: String ->
                    val levels = Arrays.stream(line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                        .mapToInt { s: String -> s.toInt() }.toArray()
                    Report(levels)
                }.collect(Collectors.toList())
                safeReports(reports)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Error reading file")
        }
    }
}
