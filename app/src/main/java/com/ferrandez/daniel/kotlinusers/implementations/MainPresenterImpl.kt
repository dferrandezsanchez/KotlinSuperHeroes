package com.ferrandez.daniel.kotlinusers.implementations

import com.ferrandez.daniel.kotlinusers.api.Model
import com.ferrandez.daniel.kotlinusers.interfaces.MainPresenter
import com.ferrandez.daniel.kotlinusers.interfaces.MainRepository
import com.ferrandez.daniel.kotlinusers.interfaces.MainView

class MainPresenterImpl(private var mView: MainView?) : MainPresenter {

    private var mRepository: MainRepository ? = MainRepositoryImpl(this)


    override fun getUsers() {
        mRepository?.getUsers()
    }

    override fun getUsersSuccess(result: Model) {
        mView?.getUsersSuccess(result)
    }

    override fun getUsersError(error: Throwable) {
        mView?.getUsersError(error)
    }
}