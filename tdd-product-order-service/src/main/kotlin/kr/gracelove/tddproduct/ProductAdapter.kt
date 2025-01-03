package kr.gracelove.tddproduct

class ProductAdapter(
    private val productRepository: ProductRepository
) : ProductPort {

    override fun save(product: Product) {
        productRepository.save(product)
    }
}