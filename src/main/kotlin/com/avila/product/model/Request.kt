package com.avila.product.model

data class ProductRequest (
    val name: String,
    val description: String,
    val price: Double,
    val available: Boolean
)

fun ProductRequest.build() = Product (
    name = this.name,
    description = this.description,
    price = this.price,
    available = this.available
)
