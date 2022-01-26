package me.miftah.simplecleanarchitecture.di

import me.miftah.simplecleanarchitecture.data.IMessageDataSource
import me.miftah.simplecleanarchitecture.data.MessageDataSource
import me.miftah.simplecleanarchitecture.data.MessageRepository
import me.miftah.simplecleanarchitecture.domain.IMessageRepository
import me.miftah.simplecleanarchitecture.domain.MessageInteractor
import me.miftah.simplecleanarchitecture.domain.MessageUseCase

object Injection {

    private fun provideDataSource(): IMessageDataSource{
        return MessageDataSource()
    }

    private fun provideRepository(): IMessageRepository{
        val messDataSource = provideDataSource()
        return MessageRepository(messDataSource)
    }

    fun provideUseCase(): MessageUseCase{
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }
}