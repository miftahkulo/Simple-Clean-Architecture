package me.miftah.simplecleanarchitecture.data

import me.miftah.simplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity = MessageEntity(
        "Assalamulaikum $name, bgaimana kabarmu?"
    )
}