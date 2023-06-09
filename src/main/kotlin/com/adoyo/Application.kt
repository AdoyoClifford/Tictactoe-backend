package com.adoyo

import com.adoyo.model.TicTacToeGame
import io.ktor.server.application.*
import com.adoyo.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val game = TicTacToeGame()
    configureMonitoring()
    configureSerialization()
    configureSockets()
    configureRouting(game)
}
