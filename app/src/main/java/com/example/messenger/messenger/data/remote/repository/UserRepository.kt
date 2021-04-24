package com.example.messenger.messenger.data.remote.repository

import com.example.messenger.messenger.data.vo.UserListVO
import com.example.messenger.messenger.data.vo.UserVO
import io.reactivex.Observable

interface UserRepository {
    fun findById(id: Long): Observable<UserVO>
    fun all(): Observable<UserListVO>
    fun echoDetails(): Observable<UserVO>




}