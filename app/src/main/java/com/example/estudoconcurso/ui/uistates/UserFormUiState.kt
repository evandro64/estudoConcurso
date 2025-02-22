package com.example.estudoconcurso.ui.uistates

data class UserFormUiState (
    val nome: String = "",
    val idade: Int = 0,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)