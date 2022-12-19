package com.digipod.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digipod.musicplayer.databinding.ActivityFavouriteBinding

class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayer)
        binding=ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}