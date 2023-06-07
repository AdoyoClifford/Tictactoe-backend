package com.adoyo

import com.adoyo.model.MakeTurn
import com.adoyo.model.TicTacToeGame
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun Route.socket(game: TicTacToeGame) {
    route("/play") {
        webSocket {
            val player = game.connectPlayer(this)

            if (player == null) {
                close(CloseReason(CloseReason.Codes.CANNOT_ACCEPT,"two players already connected"))
            }

            try {
                incoming.consumeEach {frame ->
                    if (frame is Frame.Text) {

                    }
                }

            } catch (e: Exception) {

            } finally {

            }

        }
    }
}

private fun extractAction(message: String): MakeTurn {
    val type = message.substringBefore("#")
    val body = message.substringAfter("#")

    return if (type == "make_turn") {
        Json.decodeFromString(body)
    } else MakeTurn(-1,-1)
}