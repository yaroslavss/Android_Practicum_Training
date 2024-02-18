package com.example.user.kotlintraining.part2

import java.time.LocalTime

/*
  3. Реализовать класс данных User с полями id, name, age и type.
     У класса User создать ленивое свойство startTime,
     в котором получаем текущее время.
 */
data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val type: Type,
) {
    val startTime by lazy { LocalTime.now() }
}