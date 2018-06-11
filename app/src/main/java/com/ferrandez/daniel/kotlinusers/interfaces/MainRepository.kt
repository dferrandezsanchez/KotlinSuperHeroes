package com.ferrandez.daniel.kotlinusers.interfaces

import com.ferrandez.daniel.kotlinusers.api.Model

interface MainRepository {
    fun getUsers()
    fun getUsersSuccess(result: Model)
    fun getUsersError(error: Throwable)
}