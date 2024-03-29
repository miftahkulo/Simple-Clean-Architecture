package me.miftah.simplecleanarchitecture.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MessageUseCaseTest {
    private lateinit var messageUseCase: MessageUseCase
    @Mock private lateinit var messageRepository: IMessageRepository

    @Before
    fun setup(){
        messageUseCase = MessageInteractor(messageRepository)
        val dummyMessage = MessageEntity("Assalamualaikum $NAME, How are tou")
        `when`(messageRepository.getWelcomeMessage(NAME)).thenReturn(dummyMessage)
    }

    @Test
    fun `should get data from repository`() {
        val message = messageUseCase.getMessage(NAME)
        verify(messageRepository).getWelcomeMessage(NAME)
        verifyNoMoreInteractions(messageRepository)
        Assert.assertEquals("Assalamualaikum $NAME, How are tou", message.welcomeMessage)
    }
    companion object {
        const val NAME = "Miftah Kulo"
    }
}