package com.ferrandez.daniel.kotlinusers

/*
*  A first approach to Kotlin MVP
* */

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ferrandez.daniel.kotlinusers.adapter.UsersAdapterApi
import com.ferrandez.daniel.kotlinusers.api.Model
import com.ferrandez.daniel.kotlinusers.implementations.MainPresenterImpl
import com.ferrandez.daniel.kotlinusers.interfaces.MainPresenter
import com.ferrandez.daniel.kotlinusers.interfaces.MainView
import com.ferrandez.daniel.kotlinusers.model.UserModelApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private var userListApi: ArrayList<UserModelApi> = ArrayList()

    private var mPresenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }


    private fun initialize() {
        rv_users.layoutManager = LinearLayoutManager(this)
        mPresenter = MainPresenterImpl(this)
        getUsers()
    }

    override fun getUsers() {
        mPresenter?.getUsers()
        showLoading()
    }

    override fun getUsersSuccess(result: Model) {
        userListApi = result.results as ArrayList<UserModelApi>
        rv_users.adapter = UsersAdapterApi(userListApi, this)
        hideLoading()
    }

    override fun getUsersError(error: Throwable) {
        hideLoading()
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }
}
