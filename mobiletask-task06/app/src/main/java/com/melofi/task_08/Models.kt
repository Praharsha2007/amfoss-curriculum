package com.melofi.task_08

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val username: String,
    @SerializedName("user_id")
    val userId: Int
)

data class LoginRequest(
    val username: String,
    val password: String
)

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)

data class Song(
    val id: String,
    @SerializedName("track_name")
    val trackName: String,
    @SerializedName("artist_name")
    val artistName: String,
    val audio: String,
    val cover: String?
)

data class PlaylistResponse(
    val id: Int,
    val name: String
)
