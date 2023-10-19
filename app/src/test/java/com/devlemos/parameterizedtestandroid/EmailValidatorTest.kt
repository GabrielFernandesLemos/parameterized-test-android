package com.devlemos.parameterizedtestandroid

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class EmailValidatorTest(
    private val email: String,
    private val expected: Boolean
){

    lateinit var emailValidator: EmailValidator

    @Before
    fun setUp() {
        emailValidator = EmailValidator()
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(
            name = "when email is {0}, then we are getting {1}"
        )
        fun getValidateEmailResult(): Iterable<Array<Any>> {
            /* (input, expected) */
            return arrayListOf(
                arrayOf("calabreso@gmail.pk", true),
                arrayOf("Liminado@gmail.com", true),
                arrayOf("123456", false),
                arrayOf("ludimilo@gmail.com", true),
                arrayOf("limonado", false),
                arrayOf(".,tartarugo", false),
                arrayOf("FantoLaranjo@gmail.com", true),
                arrayOf("@.Taturano", false),
                arrayOf("lasanho", false),
                arrayOf("Chicleto@gmail.com", true),
                arrayOf("TheAmusedGamer@gmail.com", true),
                arrayOf("@abc@.com", false),
                arrayOf("Canjico.com", false),
                arrayOf("TheFascinatedGamer@gmail.com", true),
                arrayOf("https://google.com", false),
                arrayOf("muçarelo", false),
                arrayOf("Capivaro@gmail.co", true),
            )
        }
    }

    @Test
    fun `test validate email`() {
        val result = emailValidator(email)

        Assert.assertEquals(result, expected)
    }
}