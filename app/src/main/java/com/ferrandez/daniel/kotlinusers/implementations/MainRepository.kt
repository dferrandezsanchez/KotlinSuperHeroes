package com.ferrandez.daniel.kotlinusers.implementations

import com.ferrandez.daniel.kotlinusers.api.ApiServiceInterface
import com.ferrandez.daniel.kotlinusers.api.Model
import com.ferrandez.daniel.kotlinusers.interfaces.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainRepositoryImpl(private var mainPresenterImpl: MainPresenterImpl) : MainRepository {


    private var disposable: Disposable? = null
    private val apiServiceInterface by lazy {
        ApiServiceInterface.create()
    }

    override fun getUsers() {
        disposable =
                apiServiceInterface.getUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> getUsersSuccess(result)},
                                { error ->  getUsersError(error)}
                        )
    }

    override fun getUsersSuccess(result: Model) {
        mainPresenterImpl?.getUsersSuccess(result)
    }

    override fun getUsersError(error: Throwable) {
        mainPresenterImpl?.getUsersError(error)
    }
}