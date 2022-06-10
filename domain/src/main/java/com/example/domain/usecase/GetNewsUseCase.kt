package com.example.domain.usecase

import com.example.domain.model.DomainNewsAllResponse
import com.example.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

// repository를 hilt를 이용해 주입받아 하나의 하나의 세부적인 기능을 선언한다
class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(
        apiKey: String,
        scope: CoroutineScope,
        onResult: (DomainNewsAllResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                newsRepository.getNews(apiKey)
            }
            onResult(deferred.await())
        }
    }
}