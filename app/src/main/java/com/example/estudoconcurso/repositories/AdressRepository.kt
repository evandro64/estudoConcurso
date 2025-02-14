package com.example.estudoconcurso.repositories

import com.example.estudoconcurso.repositories.responses.AddressResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AddressRepository(private val httpClient: HttpClient) {

    suspend fun findAddress(cep: String) =
        httpClient.get("https://viacep.com.br/ws/$cep/json/")
                .body<AddressResponse>()

}