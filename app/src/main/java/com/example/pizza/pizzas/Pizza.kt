package com.example.pizza.pizzas

import java.util.UUID

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Int,
    val desc: String,
    val image: Int
)
