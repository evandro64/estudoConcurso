package com.example.estudoconcurso.repositories.responses

import com.example.estudoconcurso.ui.uistates.UserFormUiState
import kotlinx.serialization.Serializable

@Serializable
class UserResponse (
    private val Nome: String,
    private val Idade: Int
) {
    fun toUserFormUiState() = UserFormUiState(
        nome = Nome,
        idade = Idade
    )
}