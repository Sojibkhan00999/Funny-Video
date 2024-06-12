package com.ibrahim.haventune

import android.content.Context
import android.util.AttributeSet
import android.webkit.JavascriptInterface
import android.webkit.WebView

/**
 *  * Created by Jummania on 12,June,2024.
 *  * Email: sharifuddinjumman@gmail.com
 *  * Dhaka, Bangladesh.
 */
class JPlayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

    private var isPlaying: Boolean = false
    private var onPlayingListener: OnPlayingListener? = null

    fun initialize(apiKey: String, context: Context) {
        settings.javaScriptEnabled = true
        addJavascriptInterface(this, javaClass.simpleName)
        loadUrl("file:///android_asset/jPlayer.html")
    }

    fun loadVideo(videoId: String) {
        loadUrl("javascript:player.loadVideoById('$videoId', 0);")
    }


    fun play() {
        loadUrl("javascript:player.playVideo();")
    }


    fun pause() {
        loadUrl("javascript:player.pauseVideo();")
    }

    @JavascriptInterface
    fun isPlaying(isPlaying: Boolean) {
        this.isPlaying = isPlaying
        onPlayingListener?.isPlaying(isPlaying)
    }

    fun isPlaying(): Boolean {
        return isPlaying
    }

    fun setOnPlayingListener(listener: OnPlayingListener) {
        this.onPlayingListener = listener
    }

    interface OnPlayingListener {
        fun isPlaying(isPlaying: Boolean)
    }

}