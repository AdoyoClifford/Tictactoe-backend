package com.adoyo

import com.adoyo.model.TicTacToeGame
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import com.adoyo.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        val game = TicTacToeGame()
        application {
            configureRouting(game)
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
