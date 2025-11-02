package com.example.mytodoz.domain.usecase

import com.example.mytodoz.domain.models.Note
import com.example.mytodoz.domain.repository.NoteRepository

class GetNoteByIdUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? = repository.getById(id)
}
