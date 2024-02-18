package com.example.user.kotlintraining.part2

/*
  12. Реализовать изолированный класс Action и его наследников – Registration, Login и Logout.
      Login должен принимать в качестве параметра экземпляр класса User.
 */
sealed class Action(val user: User, val authCallback: AuthCallback)

class Registration(user: User, authCallback: AuthCallback) : Action(user, authCallback)

class Login(user: User, authCallback: AuthCallback) : Action(user, authCallback)

class Logout(user: User, authCallback: AuthCallback) : Action(user, authCallback)