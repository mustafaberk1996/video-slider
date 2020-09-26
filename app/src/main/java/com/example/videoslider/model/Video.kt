package com.example.videoslider.model

import android.content.ClipDescription
import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class Video(
    context: Context,
   var url: String, var title: String
) {
    var mediaItem: MediaItem = MediaItem.fromUri(url)
    var player: SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()

    init {
        player.setMediaItem(mediaItem)
    }

    companion object {
        fun getList(context: Context): MutableList<Video> {
            val videoList: MutableList<Video> = mutableListOf()
            videoList.add(
                Video(
                    context,
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    "Big Buck Bunny"
                )
            )
            videoList.add(
                Video(
                    context,
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                    "Elephants Dream"
                )
            )
            videoList.add(
                Video(
                    context,
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                    "For Bigger Escapes"
                )
            )
            videoList.add(
                Video(
                    context,
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
                    "We Are Going On Bullrun"
                )
            )
            videoList.add(
                Video(
                    context,
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
                    "Sintel"
                )
            )

            return videoList
        }
    }

}