package kr.gracelove.tddproduct

class ProductRepository {
    private val persistence = mutableMapOf<Long?, Product>()
    private var sequence = 0L

    fun save(product: Product) {
        product.assignId(++sequence)
        persistence.put(product.id, product)
    }
}