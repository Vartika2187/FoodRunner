package com.internshala.foodrunner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.android.volley.toolbox.Volley
import com.internshala.foodrunner.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class SafetyStandardsActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    var sampleImages = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safety_standards)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Safety Standards"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val carouselView = findViewById<CarouselView>(R.id.carouselView);
        carouselView.setPageCount(sampleImages.size);
        carouselView.setImageListener(imageListener);
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            imageView?.setImageResource(sampleImages[position])
        }
    }
}
