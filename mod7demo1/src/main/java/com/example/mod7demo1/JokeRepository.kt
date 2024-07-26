package com.example.mod7demo1

class JokeRepository(
    private val jokeApiService: JokeApiService
) {

    suspend fun getRandomJoke() : Joke{
        return jokeApiService.getRandomJoke()
    }
}