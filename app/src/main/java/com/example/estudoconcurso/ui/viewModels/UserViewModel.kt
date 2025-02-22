package com.example.estudoconcurso.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.estudoconcurso.repositories.UserRepository
import com.example.estudoconcurso.ui.uistates.UserFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserFormUiState())
    val uiState = _uiState.asStateFlow()

    suspend fun findUsers(nome: String) {
        _uiState.update{
            it.copy(
                isLoading = true,
                isError = false
            )
        }
        _uiState.update {
            try {
                repository.findUser(nome)
                    .toUserFormUiState()
            } catch (t: Throwable) {
                Log.e("UserViewModel", "findUsers: ", t)
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
    }
}