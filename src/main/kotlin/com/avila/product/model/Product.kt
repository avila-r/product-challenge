package com.avila.product.model

import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

import java.util.UUID

/**
 * Entity class representing a Product in the application.
 * This class is mapped to the 'products' table in the database.
 */
@Table(name = "products")
@Entity class Product (

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    @Id val id: UUID? = null,

    @Column(name = "name", nullable = false)
    @field:NotBlank
    val name: String,

    @Column(name = "description", nullable = false)
    @field:NotBlank
    val description: String,

    @Column(name = "price", nullable = false)
    @field:NotNull
    @field:Digits(integer = 8, fraction = 2)
    val price: Double,

    @Column(name = "is_available_for_sale", nullable = false)
    @field:NotNull
    val available: Boolean

)
