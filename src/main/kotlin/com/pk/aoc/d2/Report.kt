package com.pk.aoc.d2

import kotlin.math.abs

data class Report(val levels: IntArray) {
    val isOrdered: Boolean
        get() {
            val sorted: IntArray = levels.sortedArray()
            val reverse = sorted.reversed().toIntArray()
            return sorted.contentEquals(levels) || reverse.contentEquals(levels)
        }

    val isRightSpaced: Boolean
        get() {
            for (i in 0 until levels.size - 1) {
                val diff = abs(levels[i] - levels[i + 1])
                if (diff > 3 || diff < 1) {
                    return false
                }
            }
            return true
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Report

        return levels.contentEquals(other.levels)
    }

    override fun hashCode(): Int {
        return levels.contentHashCode()
    }
}
