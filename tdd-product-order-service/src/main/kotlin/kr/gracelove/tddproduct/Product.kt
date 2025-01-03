package kr.gracelove.tddproduct

class Product(name: String, price: Int, discountPolicy: DiscountPolicy) {
    var id: Long? = null

    fun assignId(id: Long) {
        this.id = id
    }
}