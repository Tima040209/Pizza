package com.example.pizza.pizzas

import java.util.UUID

data class Combo(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val image: Int,
    val price: Int
)

