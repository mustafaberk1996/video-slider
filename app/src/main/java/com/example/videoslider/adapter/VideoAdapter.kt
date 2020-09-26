package com.example.videoslider.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.videoslider.MainActivity
import com.example.videoslider.R
import com.example.videoslider.model.Video
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoAdapter(val context: Context, var videoList: MutableList<Video>) : PagerAdapter() {


    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getCount(): Int {
        return videoList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(
            R.layout.rl_video_list_item,
            container,
            false
        )
        val playerView: PlayerView = view.findViewById(R.id.playerView)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val video = videoList[position]
        playerView.player = video.player
        video.player.prepare()

        tvTitle.text = video.title
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d("TAG", "destroy $position")

        val view = `object` as View
        container.removeView(view)
    }
}