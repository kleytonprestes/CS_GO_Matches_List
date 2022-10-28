package com.example.csgomatcheslist

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun loadImage(context: Context, url: String?, imageView: AppCompatImageView) {
    Glide.with(context)
        .load(url)
        .into(imageView)

}