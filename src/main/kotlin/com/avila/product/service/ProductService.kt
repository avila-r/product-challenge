package com.avila.product.service

/**
 * @Service indicates a service component in the Spring context.
 * @Transactional ensures that the method is executed within a transaction.
 */
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.UUID

import com.avila.product.repository.ProductRepository
import com.avila.product.model.Product
import com.avila.product.error.APIError as Error
import com.avila.product.error.ProductError

/**
 * Importing necessary classes from the 'result' library for handling results.
 *
 * The 'result' library provides a functional approach to error handling.
 * It defines a Result type that can represent either success 'Ok' or logical failure 'Err'.
 */
import com.github.michaelbull.result.Result as r
import com.github.michaelbull.result.Ok as ok
import com.github.michaelbull.result.Err as err



/**
 * Service class responsible for product-related business logic.
 */
@Service class ProductService ( private val repository: ProductRepository ) {

    /**
     * Method to create a new product in the database.
     *
     * @param product The product to be created.
     * @return Result containing the created Product or an APIError.
     */
    @Transactional fun create(product: Product) =
        ok(repository.save(product))

    /**
     * Method to update an existing product in the database.
     *
     * @param product The product to be updated.
     * @return Result containing the updated Product or an APIError.
     */
    @Transactional fun update(product: Product): r<Product, Error> {

        if ( !(repository.existsById(product.id)) )
            return err(ProductError.PRODUCT_NOT_FOUND)

        return ok(repository.save(product))

    }

    /**
     * Method to delete a product by its unique identifier (UUID).
     *
     * @param uuid The unique identifier of the product to be deleted.
     * @return Result containing a success message or an APIError.
     */
    @Transactional fun deleteById(uuid: UUID?): r<String, Error> {

        if (uuid == null) {
            return err(ProductError.PRODUCT_NOT_FOUND)
        }

        val product = repository.findProductById(uuid) ?: return err(ProductError.PRODUCT_NOT_FOUND)

        repository.delete(product)

        return ok("Successfully deleted product with id: $uuid")

    }

    /**
     * Method to retrieve a product by its unique identifier (UUID).
     *
     * @param uuid The unique identifier of the product to be retrieved.
     * @return Result containing the retrieved Product or an APIError.
     */
    fun getById(uuid: UUID?): r<Product, Error> {

        if (uuid == null) {
            return err(ProductError.PRODUCT_NOT_FOUND)
        }

        val product = repository.findProductById(uuid) ?: return err(ProductError.PRODUCT_NOT_FOUND)

        return ok(product)

    }

    /**
     * Method to retrieve all products from the database.
     *
     * @return Result containing a list of all Products or an APIError.
     */
    fun getAll(): r<List<Product>, Error> {

        val result = repository.findAll()

        if (result.isEmpty())
            return err(ProductError.NO_PRODUCTS_REGISTERED)

        return ok(result)

    }

}
