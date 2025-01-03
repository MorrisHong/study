package kr.gracelove.tddproduct

data class AddProductRequest(val name: String, val price: Int, val discountPolicy: DiscountPolicy)