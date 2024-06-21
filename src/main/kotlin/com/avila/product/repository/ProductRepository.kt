package com.avila.product.repository

import com.avila.product.model.Product

import jakarta.annotation.Nullable

import org.springframework.data.repository.ListCrudRepository

import java.util.UUID

/**
 * Repository interface for managing Product entities in the database.
 * This interface extends ListCrudRepository to inherit CRUD methods for Product entities.
 *
 * Methods returning nullable types (e.g., Product?, List<Product>?) indicate null-safety,
 * allowing for handling potential null values returned from database queries.
 */
interface ProductRepository : ListCrudRepository<Product, UUID> {

    fun findProductById(@Nullable uuid: UUID?): Product?

    fun findAllByName(name: String?): List<Product>?

    fun findAllByDescription(description: String?): List<Product>?

    fun findAllByPriceBetween(min: Double?, max: Double?): List<Product>?

    fun findAllByPriceIsGreaterThan(x: Double?): List<Product>?

    fun findAllByPriceIsLessThan(x: Double?): List<Product>?

    fun findAllByAvailable(state: Boolean): List<Product>?

    fun existsById(uuid: UUID?): Boolean

}
