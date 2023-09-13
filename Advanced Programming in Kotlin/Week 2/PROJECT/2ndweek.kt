import Inventory.Companion.newInventory

sealed class Ingredient {
    object Cheese : Ingredient()
    object Flour : Ingredient()
    object Egg : Ingredient()
    object Onion : Ingredient()
}

class Inventory<INGREDIENT : Ingredient> {
    private val contents: MutableList<INGREDIENT> = mutableListOf()

    fun addIngredient(ingredient: INGREDIENT) {
        contents.add(ingredient)
    }

    fun count(): Int {
        return contents.size
    }

    companion object {
        fun <INGREDIENT : Ingredient> newInventory(): Inventory<INGREDIENT> {
            return Inventory()
        }
    }
}

fun main() {
    val cheeseInventory = newInventory<Ingredient.Cheese>()
    cheeseInventory.addIngredient(Ingredient.Cheese)
    cheeseInventory.addIngredient(Ingredient.Cheese)
    println(cheeseInventory.count())
}
