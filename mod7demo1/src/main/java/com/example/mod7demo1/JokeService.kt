package com.example.mod7demo1


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JokeApiService {

    companion object {

        const val BASE_URL = "https://api.chucknorris.io/jokes/"

        //convertisseur permet de transformer le JSon en objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        //librairie qui permet d'envoyer des requêtes http
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("random")
    suspend fun getRandomJoke(): Joke

    //pour l'exemple avec un paramètre
    @GET("{id}")
    suspend fun getJokeById(@Path("id") id: Long): Joke

    object JokeApi {
        val retrofitService: JokeApiService by lazy { retrofit.create(JokeApiService::class.java) }
    }

}