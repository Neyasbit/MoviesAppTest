package com.example.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.core.R


fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.drawable.ic_no_image_bg)
        .into(this)
}
