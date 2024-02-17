package com.example.pizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.databinding.ItemComboBinding
import com.example.pizza.databinding.ItemPizzaBinding
import com.example.pizza.pizzas.Combo
import com.example.pizza.pizzas.Pizza

class PizzaAdapter(
    private val onPizzaClick: (Pizza) -> Unit,
    private val onComboClick: (Combo) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pizzaList: ArrayList<Pizza> = ArrayList()
    private val comboList: ArrayList<Combo> = ArrayList()
    private var originalPizzaList: List<Pizza> = emptyList()
    private var originalComboList: List<Combo> = emptyList()

    // Constants representing view types
    private val VIEW_TYPE_PIZZA = 1
    private val VIEW_TYPE_COMBO = 2

    fun setPizzaData(pizzas: MutableList<Pizza>) {
        originalPizzaList = pizzas.toList()
        pizzaList.clear()
        pizzaList.addAll(pizzas)
        notifyDataSetChanged()
    }

    fun setComboData(combos: MutableList<Combo>) {
        originalComboList = combos.toList()
        comboList.clear()
        comboList.addAll(combos)
        notifyDataSetChanged()
    }

    fun search(query: String) {
        val filteredPizzaList = if (query.isBlank()) {
            originalPizzaList
        } else {
            originalPizzaList.filter { pizza ->
                pizza.name.contains(query, ignoreCase = true) || pizza.desc.contains(query, ignoreCase = true)
            }
        }
        setPizzaData(filteredPizzaList.toMutableList())

        val filteredComboList = if (query.isBlank()) {
            originalComboList
        } else {
            originalComboList.filter { combo ->
                combo.name.contains(query, ignoreCase = true) || combo.description.contains(query, ignoreCase = true)
            }
        }
        setComboData(filteredComboList.toMutableList())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_PIZZA -> PizzaViewHolder(
                ItemPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            VIEW_TYPE_COMBO -> ComboViewHolder(
                ItemComboBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_PIZZA -> (holder as PizzaViewHolder).bind(pizzaList[position])
            VIEW_TYPE_COMBO -> (holder as ComboViewHolder).bind(comboList[position - pizzaList.size])
        }
    }

    override fun getItemCount() = pizzaList.size + comboList.size

    override fun getItemViewType(position: Int): Int {
        return if (position < pizzaList.size) {
            VIEW_TYPE_PIZZA
        } else {
            VIEW_TYPE_COMBO
        }
    }

    inner class PizzaViewHolder(
        private val binding: ItemPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            with(binding) {
                pizzaImage.setImageResource(pizza.image)
                pizzaTitle.text = pizza.name
                pizzaDescription.text = pizza.desc
                pizzaPrice.text = "${pizza.price} kzt"
                root.setOnClickListener {
                    onPizzaClick(pizza)
                }
            }
        }
    }

    inner class ComboViewHolder(
        private val binding: ItemComboBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(combo: Combo) {
            with(binding) {
                comboImage.setImageResource(combo.image)
                comboName.text = combo.name
                comboDescription.text = combo.description
                comboPrice.text = "${combo.price} kzt"
                root.setOnClickListener {
                    onComboClick(combo)
                }
            }
        }
    }
}
