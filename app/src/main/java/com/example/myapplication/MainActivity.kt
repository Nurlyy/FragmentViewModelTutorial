package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment.newInstance()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.place_holder2, BlankFragment2.newInstance()).commit()

        dataModel.messageToActivity.observe(this, {
            binding.textView.text = it
        })
    }
}