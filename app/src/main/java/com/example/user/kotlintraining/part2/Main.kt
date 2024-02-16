package com.example.user.kotlintraining.part2

object Main {

    fun run() {
        // task 4
        val user = User(1, "User 1", 15, Type.FULL)
        println(user.startTime)

        Thread.sleep(2000)
        println(user.startTime)

        // task 5
        val userList = mutableListOf(user)
        userList.apply {
            add(User(2, "User 2", 35, Type.FULL))
            add(User(3, "User 3", 40, Type.DEMO))
        }

        // task 6
        val fullAccessUserList = userList.filter { u -> u.type == Type.FULL }

        // task 7
        val nameList = userList.map { it.name }
        println("First name is '${nameList.getOrElse(0, {it})}'")
        println("Last name is '${nameList.getOrElse(nameList.size - 1, {it})}'")





    }

    /*
      Создать функцию-расширение класса User, которая проверяет, что юзер старше 18 лет,
      и в случае успеха выводит в лог, а в случае неуспеха возвращает ошибку.
     */
    fun User.isAdult(): String {
        return if (this.age > 18) {
            println("This user is older than 18: $this")
            "Success"
        }
        else
            "Error"
    }
}