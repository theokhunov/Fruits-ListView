package com.example.fruits

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fruits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fruits = arrayListOf<FruitModel>(
        FruitModel("apple",R.drawable.apple),
        FruitModel("apricot",R.drawable.apricot),
        FruitModel("banana",R.drawable.banana),
        FruitModel("peach",R.drawable.peach),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val adapter = CustomAdapter(this,fruits)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "${fruits[position]} tanlandi", Toast.LENGTH_SHORT).show()
            Intent(this,ImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }
    }
}