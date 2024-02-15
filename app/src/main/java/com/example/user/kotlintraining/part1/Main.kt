package com.example.user.kotlintraining.part1

object Main {

    fun run() {
        // task 2
        val book1 = Book(10, 5000)
        val book2 = Book(5, 500)
        val magazine = Magazine(2, 100)

        println(book1)
        println(book2)
        println(magazine)

        println(book1 == book2)
        println(book1.equals(book2))

        // task 3
        val book3: Book? = Book(10, 5000)
        val book4: Book? = null
        buy(book3)
        buy(book4)

        // task 4
        val sum = { x: Int, y: Int ->
            println(x + y)
        }
        sum(5, 10)
    }

    fun buy(publication: Publication?) {
        publication?.let { p ->
            println("The purchase is complete. The purchase amount was ${p.price} Eu")
        }
    }
}