package com.ferrandez.daniel.kotlinusers.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ferrandez.daniel.kotlinusers.R
import com.ferrandez.daniel.kotlinusers.model.UserModelApi
import kotlinx.android.synthetic.main.list_user_card.view.*

class UsersAdapterApi (val userList: ArrayList<UserModelApi>, private val context: Context) : RecyclerView.Adapter<UsersAdapterApi.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_user_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindUsers(userList.get(position), context)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindUsers(userModel: UserModelApi, context: Context){
            itemView.tv_name.text = (userModel.name.title + " " + userModel.name.first + " " + userModel.name.last)
            itemView.tv_age.text = userModel.email
            Glide.with(context)
                    .asBitmap()
                    .load(userModel.picture.large)
                    .into(itemView.iv_thumb)
        }
    }

}