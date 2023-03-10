package com.digipod.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digipod.musicplayer.databinding.ActivityPlaylistBinding

class PlaylistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayer)
        binding=ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}