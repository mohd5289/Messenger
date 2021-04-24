package com.example.messenger.messenger.service

import com.example.messenger.messenger.data.remote.requests.LoginRequestObject
import com.example.messenger.messenger.data.remote.requests.MessageRequestObject
import com.example.messenger.messenger.data.remote.requests.StatusUpdateRequestObject
import com.example.messenger.messenger.data.remote.requests.UserRequestObject
import com.example.messenger.messenger.data.vo.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MessengerApiService {
    companion object Factory {
        private var service: MessengerApiService? = null
        fun getInstance(): MessengerApiService {
            if (service == null) {
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("{messenger-api.ciltpcq8yqw7.us-east-2.rds.amazonaws.com/MessengerDB}")
// replace AWS_URL with URL of AWS EC2
// instance deployed in the previous chapter
                    .build()
                service = retrofit.create(MessengerApiService::class.java)
            }
            return service as MessengerApiService
        }
    }
    @POST("login")
    @Headers("Content-Type: application/json")
    fun login(@Body user: LoginRequestObject):
            Observable<retrofit2.Response<ResponseBody>>
    @POST("users/registrations")
    fun createUser(@Body user: UserRequestObject): Observable<UserVO>
    @GET("users")
    fun listUsers(@Header("Authorization") authorization: String):
            Observable<UserListVO>
    @PUT("users")
    fun updateUserStatus(
        @Body request: StatusUpdateRequestObject,
        @Header("Authorization") authorization: String): Observable<UserVO>
    @GET("users/{userId}")
    fun showUser(
        @Path("userId") userId: Long,
        @Header("Authorization") authorization: String): Observable<UserVO>
    @GET("users/details")
    fun echoDetails(@Header("Authorization") authorization: String): Observable<UserVO>

    @POST("messages")
       fun createMessage(
        @Body messageRequestObject: MessageRequestObject,
        @Header("Authorization") authorization: String): Observable<MessageVO>

    @GET("conversations")
    fun listConversations(@Header("Authorization") authorization: String): Observable<ConversationListVO>

    @GET("conversations/{conversationId}")
    fun showConversation(
        @Path("conversationId") conversationId: Long,
        @Header("Authorization") authorization: String):Observable<ConversationVO>
}