package me.miftah.simplecleanarchitecture.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<ViewBindingType : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: ViewBindingType
    protected abstract val inflater: (LayoutInflater) -> ViewBindingType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater.invoke(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
        observeViewModel()
    }
    abstract fun init()
    abstract fun observeViewModel()
}