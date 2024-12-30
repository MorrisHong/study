package container

import kr.gracelove.container.NoviceContainer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NoviceContainerTest {
    @Test
    fun test() {
        val a = NoviceContainer()
        val b = NoviceContainer()
        val c = NoviceContainer()
        val d = NoviceContainer()

        a.addWater(12.0)
        d.addWater(8.0)
        a.connectTo(b)

        println("${a.getAmount()} + ${b.getAmount()} + ${c.getAmount()} + ${d.getAmount()}")

        b.connectTo(c)
        println("${a.getAmount()} + ${b.getAmount()} + ${c.getAmount()} + ${d.getAmount()}")

        b.connectTo(d)
        println("${a.getAmount()} + ${b.getAmount()} + ${c.getAmount()} + ${d.getAmount()}")
    }
}