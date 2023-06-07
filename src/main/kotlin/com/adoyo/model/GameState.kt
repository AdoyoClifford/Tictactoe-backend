package com.adoyo.model

import kotlinx.serialization.Serializable

@Serializable
data class GameState(
    val playerAtTurn: Char? = 'X',
    val filed: Array<Array<Char?>> = emptyField(),
    val winningPlayer:Char? = null,
    val isBoardFull: Boolean,
    val connectedPlayer: List<Char> = emptyList()

) {
    companion object {
        fun emptyField(): Array<Array<Char?>> {
            return arrayOf(
                arrayOf(null, null, null),
                arrayOf(null, null, null),
                arrayOf(null, null, null)
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameState

        if (playerAtTurn != other.playerAtTurn) return false
        if (!filed.contentDeepEquals(other.filed)) return false
        if (winningPlayer != other.winningPlayer) return false
        return isBoardFull == other.isBoardFull
    }

    override fun hashCode(): Int {
        var result = playerAtTurn?.hashCode() ?: 0
        result = 31 * result + filed.contentDeepHashCode()
        result = 31 * result + (winningPlayer?.hashCode() ?: 0)
        result = 31 * result + isBoardFull.hashCode()
        return result
    }
}
