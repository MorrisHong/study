package kr.gracelove.tddproduct

class ProductService(
     val productPort: ProductServiceTest.ProductPort
) {


    fun addProduct(request: ProductServiceTest.AddProductRequest) {
        val product = ProductServiceTest.Product(request.name, request.price, request.discountPolicy)

        productPort.save(product)
    }
}