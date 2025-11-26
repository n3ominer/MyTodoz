package com.example.mytodoz.data.mapper

import com.example.mytodoz.data.remote.models.NoteDto
import org.junit.Assert.assertEquals
import org.junit.Test

class NoteMapperTest {

    @Test
    fun `mapper should copy fields from DTO to Model`() {
        // Create DTO
        val dto = NoteDto(5, "Some title", "Some content")

        // Execute fun behavior
        val note = mapNoteDtoToNote(dto)

        // Test result
        assertEquals(note.id, dto.id)
        assertEquals(note.content, dto.content)
        assertEquals(note.title, dto.title)
    }
}