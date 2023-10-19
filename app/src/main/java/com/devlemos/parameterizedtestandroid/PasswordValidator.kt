package com.devlemos.parameterizedtestandroid

class PasswordValidator {
    operator fun invoke(password: String): Boolean {
        // critérios de validação da senha
        val minLength = 8
        val hasUppercase = "[A-Z]".toRegex().containsMatchIn(password)
        val hasLowercase = "[a-z]".toRegex().containsMatchIn(password)
        val hasDigit = "\\d".toRegex().containsMatchIn(password)

        return password.length >= minLength && hasUppercase && hasLowercase && hasDigit

        //    val password1 = "Senha123"
        //    val password2 = "senhafraca"
    }

}