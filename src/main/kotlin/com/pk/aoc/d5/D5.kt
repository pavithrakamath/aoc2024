package com.pk.aoc.d5

class D5 {


}

fun main() {
    val rules = D5::class.java.getResource("/D5Rules.txt").readText().split("\n")
    val ruleMap = mutableMapOf<Int, List<Int>>()
    rules.forEach {
        val parts = it.split("|")
        ruleMap[parts[1].toInt()] = ruleMap.getOrDefault(parts[1].toInt(), emptyList()) + parts[0].toInt()
    }
    //read D5Input.txt as a List<List<Int>> separated by comma
    val input = D5::class.java.getResource("/D5Input.txt").readText().split("\n").map {
        it.split(",").map { it.toInt() }
    }
    var count = 0
    var orderedPages = listOf<Int>()
    input.forEach {
        val midPage = findMidIfOrdered(it, ruleMap)
        if (midPage != 0) {
            orderedPages += midPage
        }
        count += midPage
    }
    println("Total count = $count")


}

fun findMidIfOrdered(pages: List<Int>, rules: Map<Int, List<Int>>): Int {
    for (i in pages.indices) {
        val rule = rules[pages[i]]
        if (rule != null) {
            if (rule.any { pages.indexOf(it) > i }) {
                return 0
            }
        }
    }
    println("this page is ordered $pages")
    return pages[pages.size / 2]
}


