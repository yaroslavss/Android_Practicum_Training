package com.example.user.kotlintraining.part2

/*
  12. Реализовать изолированный класс Action и его наследников – Registration, Login и Logout.
      Login должен принимать в качестве параметра экземпляр класса User.
 */
sealed class Action(val authCallback: AuthCallback)

class Registration(authCallback: AuthCallback) : Action(authCallback)

class Login(val user: User, authCallback: AuthCallback) : Action(authCallback)

class Logout(authCallback: AuthCallback) : Action(authCallback)