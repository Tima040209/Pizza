package com.example.pizza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza.databinding.ActivityDetailBinding

class DetailPage : AppCompatActivity(){

    companion object {
        const val KEY_PIZZA_NAME = "pizza_name"
        const val KEY_PIZZA_PRICE = "pizza_price"
        const val KEY_PIZZA_DESCRIPTION = "pizza_description"
        const val KEY_PIZZA_IMAGE = "pizza_image"
    }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizzaName = intent.getStringExtra(KEY_PIZZA_NAME)
        val pizzaPrice = intent.getIntExtra(KEY_PIZZA_PRICE, 0).toString()
        val pizzaDescription = intent.getStringExtra(KEY_PIZZA_DESCRIPTION)
        val pizzaImageResId = intent.getIntExtra(KEY_PIZZA_IMAGE, R.drawable.default_pizza_image)

        // Отображаем данные о пицце в интерфейсе
//        binding.pizzaNameTextView.text = pizzaName
//        binding.pizzaPriceTextView.text = "Price: $pizzaPrice kzt"
//        binding.pizzaDescriptionTextView.text = pizzaDescription
        binding.resultTextView.text = pizzaName
        binding.imageViewPizza.setImageResource(pizzaImageResId)
        binding.descriptionTextView.text = pizzaDescription
        binding.buyButton.text = "Добавить в корзину за ${pizzaPrice} KZT"
    }
}