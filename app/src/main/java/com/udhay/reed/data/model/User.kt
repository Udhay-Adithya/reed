package com.udhay.reed.data.model

data class User(
    val createdAt: Long,
    val email: String,
    val id: String,
    val name: String,
    val profilePicture: String,
    val updatedAt: Long
)