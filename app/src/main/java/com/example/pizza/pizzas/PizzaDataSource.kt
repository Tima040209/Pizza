package com.example.pizza.pizzas

import com.example.pizza.R

object PizzaDataSource {
    val pizzaList = arrayListOf<Pizza>(
        Pizza(
            name = "Баварская",
            desc = "Острые колбаски чоризо, маринованные огурчики, красный лук, томаты, горчичный соус, моцарелла, фирменный томатный соус",
            price = 2700,
            image = R.drawable.bavarskaya
        ),
        Pizza(
            name = "Вау! Кебаб",
            desc = "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус",
            price = 2900,
            image = R.drawable.kebab
        ),
        Pizza(
            name = "Пепперони с грибами",
            desc = "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо",
            price = 2000,
            image = R.drawable.pepperoni
        ),
        Pizza(
            name = "Сырная",
            desc = "Моцарелла, сыры чеддер и пармезан, соус альфредо",
            price = 1900,
            image = R.drawable.cheese
        ),
        Pizza(
            name = "Карбонара",
            desc = "Ветчина из цыпленка, сыры чеддер и пармезан, томаты, красный лучок, моцарелла, соус альфредо, чеснок и итальянские травы",
            price = 2400,
            image = R.drawable.karbonara
        ),
        Pizza(
            name = "Цыпленок барбекю",
            desc = "Томатный соус, цыпленок, ветчина из мяса птицы, красный лук, моцарелла, соус Барбекю",
            price = 2700,
            image = R.drawable.barbekue
        ),

    )
}