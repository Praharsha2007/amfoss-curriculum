package com.melofi.task_08
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
//Retrofit is a http client library for Android. It allows http request sending, receive responses and also convert objects into Json format. It basically makes the communication between android and flask easy.

interface ApiService { //Interface is used because we need a blueprint of all the endpoints which are going to be used here. It enables automation. If it was a normal class then we would be required to write lots of code for even post and get request.

    @POST("register")
    suspend fun register( //Suspend allows to pause. Sometimes the network calls like post and get are slow. So instead of crashing the function would be able to do other work. Similar to async.
        @Body request: RegisterRequest //@Body tells retrofit to convert this object to JSON format and put it inside HTTP request body. This requires a registerrequest object. Object is an instance of a class that can hold data and perform functions.
    ): Response<UserResponse> //Response<> gives the full http response. With UserResponse within it we can check if the http was successful or not or whatnot.

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<UserResponse>

    @GET("songs")
    suspend fun searchSongs(
        @Query("q") query: String
    ): Response<List<Song>>

    @GET("trending")
    suspend fun getTrending(): Response<List<Song>>

    @GET("playlist/all")
    suspend fun getPlaylists(
        @Query("username") username: String
    ): Response<List<PlaylistResponse>>
}
