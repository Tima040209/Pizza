package com.example.pizza.pizzas

import com.example.pizza.R

object ComboDataSource {
    val comboList = arrayListOf<Combo>(
        Combo(
            name = "Комбо за 3900 Т",
            description = "Кому-кому только одному. Маленькая пицца, закуска, напиток и соус. Цена комбо зависит от выбранных продуктов и может быть увеличена",
            image = R.drawable.three,
            price = 3900
        )
        ,
        Combo(
            name = "Комбо от Смешариков",
            description = "Одобрено героями мультфильма: маленькая пицца любого вкуса и набор юного садовода. Цена комбо зависит от выбранных пицц и может быть увеличена",
            image = R.drawable.img,
            price = 2750
        )
    )
}