package kr.gracelove.tddproduct

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductServiceTest {

    private var productService: ProductService? = null
    private var productPort: ProductPort? = null
    private var productRepository: ProductRepository? = null

    @BeforeEach
    fun setUp() {
        productRepository = ProductRepository()
        productPort = ProductAdapter(productRepository!!)
        productService = ProductService(productPort!!)
    }

    @Test
    fun 상품등록() {
        val request = 상품_등록_요청()

        productService!!.addProduct(request)
    }

    private fun 상품_등록_요청(): AddProductRequest {
        val name = "상품명"
        val price = 1000
        val discountPolicy = DiscountPolicy.NONE
        val request = AddProductRequest(name, price, discountPolicy)
        return request
    }
}


