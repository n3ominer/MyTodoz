package com.example.mytodoz.data.mapper

import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.models.Note

fun mapNoteDtoToNote(dto: NoteDto): Note {
    return Note(
        id = dto.id,
        title = dto.title,
        content = dto.content,
        colorIndex = dto.colorIndex
    )
}