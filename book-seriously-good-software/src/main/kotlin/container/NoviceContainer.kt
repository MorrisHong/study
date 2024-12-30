package kr.gracelove.container

class NoviceContainer: Container{
    val amount: Double = 0.0
    val connectedTo: MutableList<Container> = mutableListOf()

    override fun getAmount(): Double {

    }

    override fun connectTo(other: Container) {

    }

    override fun addWater(amount: Double) {

    }
}