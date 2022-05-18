package com.rahul.daggerhilt

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}