package me.miftah.simplecleanarchitecture.data

import me.miftah.simplecleanarchitecture.domain.IMessageRepository
import me.miftah.simplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity =
        messDataSource.getMessageFromSource(name)
}