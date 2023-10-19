package com.devlemos.parameterizedtestandroid

class EmailValidator {
    operator fun invoke(email: String): Boolean {
        // critérios de validação de e-mail
        val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$".toRegex()

        // Verifica se o e-mail corresponde à expressão regular
        return emailRegex.matches(email)

//        val email1 = "usuario@example.com"
//        val email2 = "email_invalido"
    }
}