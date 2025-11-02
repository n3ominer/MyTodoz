package com.example.mytodoz.domain.usecase

import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(): List<NoteDto> = repository.getAllNotes()
}
