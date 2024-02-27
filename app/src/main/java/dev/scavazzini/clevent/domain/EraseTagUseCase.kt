package dev.scavazzini.clevent.domain

import android.content.Intent
import dev.scavazzini.clevent.data.repositories.TagRepository
import javax.inject.Inject

class EraseTagUseCase @Inject constructor(
    private val tagRepository: TagRepository,
) {
    suspend operator fun invoke(intent: Intent) {
        tagRepository.erase(intent)
    }
}