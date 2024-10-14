package com.example.myapplication.data

import com.example.myapplication.logic.Client

class RepositoryClient {
    companion object {
        var primary = 100

        val arrayClient : List<Client> = listOf (
            Client (RepositoryClient.incrementPrimary(), "David"),
            Client (RepositoryClient.incrementPrimary(), "Pablo"),
            Client (RepositoryClient.incrementPrimary(), "Juanra"),
            Client (RepositoryClient.incrementPrimary(), "Diego")
        )

        fun incrementPrimary() = primary ++
    }

}