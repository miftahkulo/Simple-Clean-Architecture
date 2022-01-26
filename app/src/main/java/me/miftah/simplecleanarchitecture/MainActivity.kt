package me.miftah.simplecleanarchitecture

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import me.miftah.simplecleanarchitecture.base.BaseActivity
import me.miftah.simplecleanarchitecture.databinding.ActivityMainBinding
import me.miftah.simplecleanarchitecture.presentaton.MainViewModel
import me.miftah.simplecleanarchitecture.presentaton.MainViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private lateinit var viewModel: MainViewModel

    override fun init() {
        val factory = MainViewModelFactory.getInsance()
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.setName("Kangmas Miftah")
    }

    override fun observeViewModel() {
        viewModel.message.observe(this, {
            binding.tvWelcome.text = it.welcomeMessage
        })
    }
}