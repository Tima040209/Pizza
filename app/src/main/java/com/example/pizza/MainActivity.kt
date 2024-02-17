package com.example.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.pizza.adapter.PizzaAdapter
import com.example.pizza.databinding.ActivityMainBinding
import com.example.pizza.pizzas.Combo
import com.example.pizza.pizzas.Pizza
import com.example.pizza.pizzas.PizzaDataSource
import com.example.pizza.pizzas.ComboDataSource


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PizzaAdapter(
            onPizzaClick = { pizza -> handlePizzaClick(pizza) },
            onComboClick = { combo -> handleComboClick(combo) }
        )
        binding.recyclerView.adapter = adapter
        adapter.setPizzaData(PizzaDataSource.pizzaList)
        adapter.setComboData(ComboDataSource.comboList)

        // Добавляем слушателя текста для поля поиска
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.search(s.toString()) // Вызываем метод поиска адаптера при изменении текста
            }
        })
    }

    private fun handlePizzaClick(pizza: Pizza) {
        val intent = Intent(this, DetailPage::class.java).apply {
            putExtra(DetailPage.KEY_PIZZA_NAME, pizza.name)
            putExtra(DetailPage.KEY_PIZZA_PRICE, pizza.price)
            putExtra(DetailPage.KEY_PIZZA_DESCRIPTION, pizza.desc)
            putExtra(DetailPage.KEY_PIZZA_IMAGE, pizza.image)
        }
        startActivity(intent)
    }

    private fun handleComboClick(combo: Combo) {
        // Обработка нажатия на элемент комбо
    }
}
