package me.miftah.simplecleanarchitecture.domain

class MessageInteractor(private val messRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messRepository.getWelcomeMessage(name)
    }
}