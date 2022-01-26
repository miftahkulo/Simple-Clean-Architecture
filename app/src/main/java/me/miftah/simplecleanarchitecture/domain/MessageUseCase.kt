package me.miftah.simplecleanarchitecture.domain

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}