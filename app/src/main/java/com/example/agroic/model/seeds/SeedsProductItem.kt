package com.example.agroic.model.seeds

data class SeedsProductItem(
    val __v: Int,
    val _id: String,
    val category: String,
    val countInStock: Int,
    val createdAt: String,
    val description: String,
    val image: String,
    val name: String,
    val numReviews: Int,
    val price: Int,
    val rating: Double,
    val reviews: List<SeedsProductReview>,
    val updatedAt: String,
    val user: String
)