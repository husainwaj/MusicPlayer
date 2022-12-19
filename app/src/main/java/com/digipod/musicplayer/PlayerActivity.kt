package com.digipod.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.digipod.musicplayer.databinding.ActivityPlayerBinding
import com.digipod.musicplayer.databinding.ActivityPlaylistBinding
import java.lang.Exception

class PlayerActivity : AppCompatActivity() {

    companion object{
        lateinit var musicListPA:ArrayList<Music>
        var songPosition:Int=0
        var mediaPlayer:MediaPlayer?=null
        var isPlaying:Boolean=false
    }


    private lateinit var binding: ActivityPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayer)
        binding= ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
       songPosition= intent.getIntExtra("index",0)
        when(intent.getStringExtra("class")){
            "MusicAdapter"->{
                musicListPA=ArrayList()
                musicListPA.addAll(MainActivity.MusicListMA)
                setLayout()
                createMediaPlayer()
                binding.playPauseBtnPA.setOnClickListener{
                    if(isPlaying) pauseMusic()
                    else playMusic()
                }

            }
        }

    }
    private fun setLayout(){
        Glide.with(this)
            .load(musicListPA[songPosition].artUri)
            .apply(RequestOptions().placeholder(R.drawable.splashscreen).centerCrop())
            .into(binding.songImgPA)
        binding.songNamePA.text= musicListPA[songPosition].title
    }
    private fun createMediaPlayer(){
        try{
            if(mediaPlayer==null) mediaPlayer= MediaPlayer()
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(musicListPA[songPosition].path)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
            isPlaying=true
            binding.playPauseBtnPA.setIconResource(R.drawable.pause_icon)
        }
        catch (e:Exception){return}
    }
    private fun playMusic(){
        binding.playPauseBtnPA.setIconResource(R.drawable.pause_icon)
        isPlaying=true
        mediaPlayer!!.start()
    }
    private fun pauseMusic(){
        binding.playPauseBtnPA.setIconResource(R.drawable.play_icon)
        isPlaying=false
        mediaPlayer!!.pause()
    }
}