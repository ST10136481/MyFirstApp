package com.example.myfirstapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView7.setOnClickListener(this)
        binding.imageView2.setOnClickListener(this)
        binding.imageView3.setOnClickListener(this)
        binding.imageView4.setOnClickListener(this)
        binding.imageView5.setOnClickListener(this)
        binding.imageView6.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.imageView7 -> order.productName = "Chocolate Milk"
            R.id.imageView2 -> order.productName = "Steri Stumpie"
            R.id.imageView3 -> order.productName = "Coke a Coke"
            R.id.imageView4 -> order.productName = "Architect's Daughter"
            R.id.imageView5 -> order.productName = "Ross's Milk"
            R.id.imageView6 -> order.productName = "Agua"
        }

        Toast.makeText(this@MainActivity, "Yummy Stuff Man " + order.productName,
            Toast.LENGTH_SHORT).show()

        openIntent(this, order.productName, OrderDetailsActivity::class.java)
    }
}