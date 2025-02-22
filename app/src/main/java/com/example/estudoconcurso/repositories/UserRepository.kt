package com.example.estudoconcurso.repositories

import com.example.estudoconcurso.repositories.responses.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserRepository(private val httpClient: HttpClient)   {
    suspend fun findUser(nome: String) =
        httpClient.get("http://192.168.0.112:3000/user/user")
            .body<UserResponse>()
}