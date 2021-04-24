package com.example.messenger.messenger.data.remote.requests

data class LoginRequestObject(
    val username: String,
    val password: String
)
data class MessageRequestObject(val recipientId: Long, val message: String)
data class StatusUpdateRequestObject(val status: String)
data class UserRequestObject(
    val username: String,
    val password: String,
    val phoneNumber: String = ""
)
