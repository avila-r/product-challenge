package com.avila.product.error

import org.springframework.http.HttpStatus

/**
 * Interface defining the structure for API errors.
 */
interface APIError {
    val status: HttpStatus
    val message: String
}

/**
 * Data class representing an API error response.
 */
data class APIErrorResponse (
    val status: String,
    val message: String
)

/**
 * Extension function to retrieve the Spring's Response Entity from any implementation of [Error].
 * @return The response entity.
 */
fun APIError.response() = APIErrorResponse (
    status = this.status.toString(),
    message = this.message
)
