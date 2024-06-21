package com.avila.product.error

import org.springframework.http.HttpStatus

/**
 * Enum representing product-related errors that can occur in the system.
 */
enum class ProductError : APIError {

    /**
     * Error indicating that a post/patch/put request for a product is invalid.
     */
    INVALID_PRODUCT_REQUEST {
        override val status = HttpStatus.UNPROCESSABLE_ENTITY
        override val message = "invalid product insertion request"
    },

    /**
     * Error indicating that doesn't exist registered products.
     */
    NO_PRODUCTS_REGISTERED {
        override val status = HttpStatus.NOT_FOUND
        override val message = "no products registered"
    },

    /**
     * Error indicating that a requested product was not found.
     */
    PRODUCT_NOT_FOUND {
        override val status = HttpStatus.NOT_FOUND
        override val message = "product not found"
    };

    override fun toString() = message

}
