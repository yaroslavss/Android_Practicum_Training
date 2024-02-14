package com.example.user.kotlintraining.part1

import kotlin.math.abs

class Book(price: Int, wordCount: Int) : Publication {

    override val price: Int = abs(price)
    override val wordCount: Int = abs(wordCount)

    override fun getType() = when (wordCount) {
        in 0..1000 -> "Flash Fiction"
        in 1001..7500 -> "Short Story"
        else -> "Novel" }

    override fun toString(): String {
        return "Книга: [Тип: ${getType()}, Количество строк=$wordCount, Цена=$price Eu]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (price != other.price) return false
        if (wordCount != other.wordCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = price
        result = 31 * result + wordCount
        return result
    }
}