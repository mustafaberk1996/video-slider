package com.example.videoslider.model

import android.content.Context
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class Video(var context: Context,var url:String,var title:String) {
    var mediaItem:MediaItem = MediaItem.fromUri(this.url)
    var player:SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()
    init {
        player.setMediaItem(mediaItem)
    }
}