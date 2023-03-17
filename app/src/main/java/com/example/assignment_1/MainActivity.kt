package com.example.assignment_1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //array of Recipe categories to spinner items
    private val categoriesOptions = arrayOf("Appetizers", "Main Course", "Desserts")
    private var selectedCategory : String = categoriesOptions[0] //select first option by default.
    private var selectedCategoryIndex : Int = 0

    private val appetizers = arrayOf("Garlic Bread", "Caprese Salad Skewers", "Deviled Eggs", "Guacamole", "Bruschetta ")
    private val mainCourse = arrayOf("Spaghetti Bolognese", "Chicken Curry", "Grilled Salmon", "Veggie Burger", "Beef Stroganoff")
    private val desserts = arrayOf("Chocolate Chip Cookies", "Apple Crisp", "Tiramisu ", "Cheesecake", "Chocolate Cake")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //define and access views.
        val myButton : Button = findViewById(R.id.my_button)
        val mySpinner : Spinner = findViewById(R.id.my_spinner)
        val resultText : TextView = findViewById(R.id.resultText)



        //set spinner items
        mySpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,categoriesOptions)

        myButton.setOnClickListener {
            // generate random Recipe from the selected category when the button is clicked
            println("Butten Clickedd");
            val randomAppetizer = appetizers.random()
            val randomMainCourse = mainCourse.random()
            val randomDessert = desserts.random()

            val selectedRecipe : String = arrayOf(randomAppetizer,randomMainCourse,randomDessert)[selectedCategoryIndex]
            resultText.text = "You can make: " + selectedRecipe

            Toast.makeText(
                applicationContext,
                "You selected:" + selectedCategory,
                Toast.LENGTH_SHORT,
            ).show()

        }

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Code to be executed when an item in the spinner is selected
                selectedCategory = categoriesOptions.get(position)
                selectedCategoryIndex = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Code to be executed when nothing is selected
                Toast.makeText(
                    applicationContext,
                    "Please, Select a Category.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}

