package com.example.user.kotlintraining.part1

import kotlin.math.abs

class Magazine(price: Int, wordCount: Int) : Publication {

    override val price: Int = abs(price)
    override val wordCount: Int = abs(wordCount)

    override fun getType() = "Magazine"

    override fun toString(): String {
        return "Журнал: [Тип: ${getType()}, Количество строк=$wordCount, Цена=$price Eu]"
    }
}