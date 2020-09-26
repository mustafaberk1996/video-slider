package com.example.videoslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.videoslider.adapter.VideoAdapter
import com.example.videoslider.model.Video
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var videoAdapter: VideoAdapter
     var videoList: MutableList<Video> = mutableListOf()

    var lastPagePosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoList.add(
            Video(
                this,
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "Big Buck Bunny"
            )
        )
        videoList.add(
            Video(
                this,
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                "Elephants Dream"
            )
        )
        videoList.add(
            Video(
                this,
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                "For Bigger Escapes"
            )
        )
        videoList.add(
            Video(
                this,
                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
                "We Are Going On Bullrun"
            )
        )

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
                lastPagePosition=position
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}