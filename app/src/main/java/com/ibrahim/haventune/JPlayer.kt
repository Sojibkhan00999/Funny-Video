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

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun initialize(apiKey: String, context: Context) {
        settings.javaScriptEnabled = true
        addJavascriptInterface(this, javaClass.simpleName)
        loadUrl("file:///android_asset/jPlayer.html")
    }

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun loadVideo(videoId: String) {
        loadUrl("javascript:player.loadVideoById('$videoId', 0);")
    }


    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun play() {
        loadUrl("javascript:player.playVideo();")
    }


    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun pause() {
        loadUrl("javascript:player.pauseVideo();")
    }

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    @JavascriptInterface
    fun isPlaying(isPlaying: Boolean) {
        this.isPlaying = isPlaying
        onPlayingListener?.isPlaying(isPlaying)
    }

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun isPlaying(): Boolean {
        return isPlaying
    }

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    fun setOnPlayingListener(listener: OnPlayingListener) {
        this.onPlayingListener = listener
    }

    /**
     *  * Author: Sharif Uddin Jumman (Jummania).
     *  * Email: sharifuddinjumman@gmail.com, arsharifuddinjumman04@gmail.com
     */
    interface OnPlayingListener {
        fun isPlaying(isPlaying: Boolean)
    }

}