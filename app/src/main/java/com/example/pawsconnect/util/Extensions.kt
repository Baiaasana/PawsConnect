package com.example.pawsconnect.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.pawsconnect.R

fun AppCompatImageView.loadImage(url: String, @DrawableRes placeholder: Int?) {
    Glide.with(this)
        .load(url)
        .placeholder(placeholder ?: R.drawable.cat_2)
        .into(this)

}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}