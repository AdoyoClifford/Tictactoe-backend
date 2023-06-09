package com.adoyo.plugins

import com.adoyo.model.TicTacToeGame
import com.adoyo.socket
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting(game: TicTacToeGame) {
    routing {
        socket(game)
    }
}
