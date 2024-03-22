package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    var order = Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)

        order.productName = intent.getStringExtra("order").toString()

        binding.drinkNameView.text = order.productName

        when (order.productName) {
            "Chocolate Milk" -> binding.imageView11.setImageResource(R.drawable.sb1)
            "Steri Stumpie" -> binding.imageView11.setImageResource(R.drawable.sb2)
            "Coke a Coke" -> binding.imageView11.setImageResource(R.drawable.sb3)
            "Architect's Daughter" -> binding.imageView11.setImageResource(R.drawable.sb4)
            "Ross's Milk" -> binding.imageView11.setImageResource(R.drawable.sb5)
            "Agua" -> binding.imageView11.setImageResource(R.drawable.sb6)
        }

        binding.fab.setOnClickListener() {
            shareIntent(applicationContext, order.productName)
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_order_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}