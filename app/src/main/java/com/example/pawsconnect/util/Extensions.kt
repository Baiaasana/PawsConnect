package com.example.pawsconnect.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.pawsconnect.R


    fun AppCompatImageView.loadImage(url: String, @DrawableRes placeholder: Int = R.drawable.cat_2 ){
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.cat_2)
            .into(this)

    }