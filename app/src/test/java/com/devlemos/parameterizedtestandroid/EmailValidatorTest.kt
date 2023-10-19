package com.devlemos.parameterizedtestandroid

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class EmailValidatorTest{

    private lateinit var emailValidator: EmailValidator

    @BeforeEach
    fun setUp() {
        emailValidator = EmailValidator()
    }

    @ParameterizedTest
    @ArgumentsSource(EmailArgumentsProvider::class)
    fun `test validate email`(email: String, isValid: Boolean) {
        val result = emailValidator(email)
        Assertions.assertEquals(result, isValid)
    }

    private class EmailArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("calabreso@gmail.pk", true),
                Arguments.of("Liminado@gmail.com", true),
                Arguments.of("123456", false),
                Arguments.of("ludimilo@gmail.com", true),
                Arguments.of("limonado", false),
                Arguments.of(".,tartarugo", false),
                Arguments.of("FantoLaranjo@gmail.com", true),
                Arguments.of("@.Taturano", false),
                Arguments.of("lasanho", false),
                Arguments.of("Chicleto@gmail.com", true),
                Arguments.of("TheAmusedGamer@gmail.com", true),
                Arguments.of("@abc@.com", false),
                Arguments.of("Canjico.com", false),
                Arguments.of("TheFascinatedGamer@gmail.com", true),
                Arguments.of("https://google.com", false),
                Arguments.of("muçarelo", false),
                Arguments.of("Capivaro@gmail.co", true)
            )
        }
    }
}