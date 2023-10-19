package com.devlemos.parameterizedtestandroid

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class PasswordValidatorTest(
    private val password: String,
    private val expected: Boolean
) {

    lateinit var validatePassword: PasswordValidator

    @Before
    fun setUp() {
        validatePassword = PasswordValidator()
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(
            name = "when password is {0}, then we are getting {1}"
        )
        fun getValidateEmailResult(): Iterable<Array<Any>> {
            /* (input, expected) */
            return arrayListOf(
                arrayOf("frigideiro", false),
                arrayOf("12345678", false),
                arrayOf("Lagosto1234", true),
                arrayOf("Creatino1234", true),
                arrayOf("agiotoD1234", true),
                arrayOf("12345Ab", false),
                arrayOf("discoteco", false),
                arrayOf("./,'./,;./,;.,", false),
                arrayOf("LamparinoAbcd1", true),
                arrayOf("@.sinuco", false),
                arrayOf("cabido", false)
            )
        }
    }

    @Test
    fun `test validate password`() {
        val result = validatePassword(password = password)

        assertEquals(result, expected)
    }
}