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
        println("First name is '${nameList.first()}'")
        println("Last name is '${nameList.last()}'")

        // task 9
        val authCallback = object : AuthCallback {
            override fun authSuccess() {
                println("Authorized")
            }

            override fun authFailed() {
                println("Not authorized")
            }
        }

        // task 10, 11
        val updateCache = { println("Cache updated") }
        auth(user, authCallback, updateCache)

        // task 13
        doAction(Login(user, authCallback), updateCache)
    }

    /*
      8. Создать функцию-расширение класса User, которая проверяет, что юзер старше 18 лет,
         и в случае успеха выводит в лог, а в случае неуспеха возвращает ошибку.
     */
    fun User.isAdult(): Pair<Boolean, String> {
        return if (this.age > 18) {
            println("This user is older than 18: $this")
            true to "Success"
        } else
            false to "This user is too much young"
    }

    /*
      10. Реализовать inline функцию auth, принимающую в качестве параметра функцию updateCache.
          Функция updateCache должна выводить в лог информацию об обновлении кэша.

      11. Внутри функции auth вызвать метод коллбека authSuccess и переданный updateCache,
          если проверка возраста пользователя произошла без ошибки.
          В случае получения ошибки вызвать authFailed.
     */
    inline fun auth(user: User, callback: AuthCallback, operation: () -> Unit) {
        val (status, message) = user.isAdult()
        if (status) {
            callback.authSuccess()
            operation()
        } else
            callback.authFailed()
    }

    /*
      13. Реализовать метод doAction, принимающий экземпляр класса Action.
          В зависимости от переданного действия выводить в лог текст,
          к примеру “Auth started”. Для действия Login вызывать метод auth.
     */
    fun doAction(action: Action, operation: () -> Unit) {
        when (action) {
            is Registration -> {
                println("Registration started")
            }

            is Login -> {
                println("Auth started")
                auth(action.user, action.authCallback, operation)
            }

            is Logout -> {
                println("Logout started")
            }
        }
    }
}