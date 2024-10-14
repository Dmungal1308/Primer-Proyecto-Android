package com.example.myapplication.data

import com.example.myapplication.logic.Client

class RepositoryClient {
    companion object {
        var primary = 100

        val arrayClient : List<Client> = listOf (
            Client (RepositoryClient.incrementPrimary(), "David", "Muñoz", 123456789),
            Client (RepositoryClient.incrementPrimary(), "Pablo", "Muñoz", 987654321),
            Client (RepositoryClient.incrementPrimary(), "Juanra", "Muñoz", 123455323),
            Client (RepositoryClient.incrementPrimary(), "Diego", "Muñoz", 123456789)
        )

        fun incrementPrimary() = primary ++
    }

}