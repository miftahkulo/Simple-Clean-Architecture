package me.miftah.simplecleanarchitecture.data

import me.miftah.simplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String):MessageEntity
}