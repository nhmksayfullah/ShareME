package com.example.shareme.domin.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}