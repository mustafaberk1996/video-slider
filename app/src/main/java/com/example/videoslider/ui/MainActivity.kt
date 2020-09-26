package com.example.videoslider.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.videoslider.R
import com.example.videoslider.adapter.VideoAdapter
import com.example.videoslider.model.Video
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    val TAG = MainActivity::class.simpleName

    lateinit var videoAdapter: VideoAdapter
    lateinit var videoList: MutableList<Video>
    var lastPagePosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoList = Video.getList(this)
        videoAdapter = VideoAdapter(this, videoList)
        vpVideos.adapter = videoAdapter

        vpVideos.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                val video = videoList[position]
                videoList[lastPagePosition].player.pause()
                video.player.play()
                lastPagePosition = position
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}