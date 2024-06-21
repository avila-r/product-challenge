package com.avila.product.controller

import com.avila.product.model.Product
import com.avila.product.model.ProductRequest
import com.avila.product.model.build
import com.avila.product.service.ProductService
import com.avila.product.util.toUUIDOrNull

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.UUID

import jakarta.validation.Valid

/**
 * Controller class for handling product-related API requests.
 * This class defines endpoints for creating, updating, deleting, and retrieving products.
 */
@RequestMapping("/api/v1/product")
@RestController class ProductHandler ( private val service: ProductService ) : Handler {

    /**
     * Endpoint for inserting a new product.
     * Validates the request body using the @Valid annotation.
     *
     * @param request The product request data.
     * @return ResponseEntity containing the result of the product creation operation.
     */
    @PostMapping
    fun insertProduct(@Valid @RequestBody request: ProductRequest) = handle (
        service.create(request.build())
    )

    /**
     * Endpoint for updating an existing product.
     * Validates the request body using the @Valid annotation.
     *
     * @param product The product data to be updated.
     * @return ResponseEntity containing the result of the product update operation.
     */
    @PatchMapping
    fun updateProduct(@Valid @RequestBody product: Product) = handle (
        service.update(product)
    )

    /**
     * Endpoint for deleting a product by its ID.
     *
     * @param id The ID of the product to be deleted.
     * @return ResponseEntity containing the result of the product deletion operation.
     */
    @DeleteMapping("/id/{id}")
    fun deleteProductById(@PathVariable id: String?) = handle (
        service.deleteById(id.toUUIDOrNull())
    )

    /**
     * Endpoint for listing all products.
     *
     * @return ResponseEntity containing the list of all products.
     */
    @GetMapping
    fun listProducts() = handle (
        service.getAll()
    )

    /**
     * Endpoint for retrieving a product by its ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return ResponseEntity containing the result of the product retrieval operation.
     */
    @GetMapping("/id/{id}")
    fun getProductById(@PathVariable id: String?) = handle (
        service.getById(id.toUUIDOrNull())
    )

}
