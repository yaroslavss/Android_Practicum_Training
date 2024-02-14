package com.example.user.kotlintraining.part1

interface Publication {

    val price: Int
    val wordCount: Int

    fun getType(): String
}