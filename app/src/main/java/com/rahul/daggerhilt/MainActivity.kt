package com.rahul.daggerhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.daggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        observeCryptoCurrency()
    }

    fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            mainBinding.cryptoList.layoutManager = LinearLayoutManager(this)
            mainBinding.cryptoList.adapter = CryptocurrencyAdapter(it)
        }
    }
}