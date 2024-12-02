package com.pk.aoc.d3

import org.junit.jupiter.api.Test

internal class D3Test {

    @Test
    fun testCompute() {
        assert(D3().compute("""mul(4*, mul(6,9!, ?(12,34),""") == 0.toBigInteger())
        assert(D3().compute("""mul(4, mul(6,9), ?(12,34),""") == 54.toBigInteger())
        assert(D3().compute("""mul(4, ++mul(6,9), mul?(12,34), mul*(4,6),""") == 54.toBigInteger())
    }
}