package com.example.estudoconcurso.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.estudoconcurso.repositories.AddressRepository
import com.example.estudoconcurso.repositories.responses.AddressResponse
import com.example.estudoconcurso.ui.uistates.AddressFormUiState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json

class AddressViewModel(
    private val repository: AddressRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddressFormUiState())
    val uiState = _uiState.asStateFlow()

    suspend fun findAddress(cep: String) {
        _uiState.update{
            it.copy(
                isLoading = true,
                isError = false
            )
        }
        _uiState.update {
            try {
                repository.findAddress(cep)
                    .toAddressFormUiState()
            } catch (t: Throwable) {
                Log.e("AddressViewModel", "findAddress: ", t)
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
    }
}