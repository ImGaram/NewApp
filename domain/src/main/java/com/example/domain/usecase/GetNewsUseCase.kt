package com.example.domain.usecase

import com.example.domain.repository.NewsRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

// repository를 hilt를 이용해 주입받아 하나의 하나의 세부적인 기능을 선언한다
class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, apiKey: String) = newsRepository.getNews(remoteErrorEmitter, apiKey)
}