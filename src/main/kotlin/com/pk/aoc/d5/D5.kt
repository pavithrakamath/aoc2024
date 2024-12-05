package com.pk.aoc.d5

class D5 {


}

fun main() {
    val rules = D5::class.java.getResource("/D5Rules.txt").readText().lineSequence()
    val ruleMap = rules.map { it.split("|").let { parts -> parts[1].toInt() to parts[0].toInt() } }
        .groupBy({ it.first }, { it.second })

    val input =
        D5::class.java.getResource("/D5Input.txt").readText().lineSequence().map { it.split(",").map(String::toInt) }

    val unordered = mutableListOf<List<Int>>()
    input.sumOf {
        val midPage = findMidIfOrdered(it, ruleMap)
        if (midPage == 0) {
            unordered.add(it)
        }
        midPage
    }.let { println("Total of mid pages of ordered = $it") }
    println("Total of mid pages for reordered = ${unordered.sumOf { reorderPages(it, ruleMap) }}")

}

fun reorderPages(orderedPages: List<Int>, rules: Map<Int, List<Int>>): Int {
    val ordered = orderedPages.toMutableList()
    var i = 0
    while (i < ordered.size) {
        //rule holds all pages that should come before the current page
        val rule = rules[ordered[i]]
        if (rule != null) {
            val indexes = rule.mapNotNull {
                // for each page that should come before the current page, find the index of the page in the ordered list
                ordered.indexOf(it).takeIf { idx -> idx > i }
            }
            if (indexes.isNotEmpty()) {
                val temp = ordered[i]
                val mid = indexes[indexes.size / 2]
                ordered[i] = ordered[mid]
                ordered[mid] = temp
                i = 0
                continue
            }
        }
        i++
    }
    return ordered[ordered.size / 2]
}

fun findMidIfOrdered(pages: List<Int>, rules: Map<Int, List<Int>>): Int {
    for (i in pages.indices) {
        val rule = rules[pages[i]]
        if (rule != null && rule.any { pages.indexOf(it) > i }) {
            return 0
        }
    }
    return pages[pages.size / 2]
}


