package com.devlemos.parameterizedtestandroid

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PasswordValidatorTest {

    private lateinit var passwordValidator: PasswordValidator

    @BeforeEach
    fun setUp() {
        passwordValidator = PasswordValidator()
    }

    @ParameterizedTest
    @ArgumentsSource(PasswordArgumentsProvider::class)
    fun `test validate password`(password: String, expected: Boolean) {
        val result = passwordValidator(password)
        Assertions.assertEquals(result, expected)
    }

    private class PasswordArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("frigideiro", false),
                Arguments.of("12345678", false),
                Arguments.of("Lagosto1234", true),
                Arguments.of("Creatino1234", true),
                Arguments.of("agiotoD1234", true),
                Arguments.of("12345Ab", false),
                Arguments.of("discoteco", false),
                Arguments.of("./,'./,;./,;.,", false),
                Arguments.of("LamparinoAbcd1", true),
                Arguments.of("@.sinuco", false),
                Arguments.of("cabido", false)
            )
        }
    }
}