package com.example.messenger.messenger.data.remote.repository

import com.example.messenger.messenger.data.vo.ConversationListVO
import com.example.messenger.messenger.data.vo.ConversationVO
import io.reactivex.Observable

interface ConversationRepository {
    fun findConversationById(id: Long): Observable<ConversationVO>
    fun all(): Observable<ConversationListVO>
}