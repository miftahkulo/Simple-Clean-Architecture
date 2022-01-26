package me.miftah.simplecleanarchitecture.presentaton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.miftah.simplecleanarchitecture.di.Injection
import me.miftah.simplecleanarchitecture.domain.MessageUseCase

class MainViewModelFactory(
    private var messageUseCase: MessageUseCase
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instant: MainViewModelFactory? = null

        fun getInsance(): MainViewModelFactory =
            instant ?: synchronized(this) {
                instant ?: MainViewModelFactory(Injection.provideUseCase())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown Model Class: $modelClass")
        }
    }
}