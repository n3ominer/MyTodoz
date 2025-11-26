package com.example.mytodoz.mapper.data

import com.example.mytodoz.data.mapper.mapNoteDtoToNote
import com.example.mytodoz.data.remote.models.NoteDto
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NoteMapperTest {

    @Test
    fun `should map data from dto to note`() {
        // Framework AAA

        // Arrange
        val dto = NoteDto(0, "Title", "Content")

        // Act
        val note = mapNoteDtoToNote(dto)

        // Assert
        assertEquals(note.id, dto.id)
        assertEquals(note.title, dto.title)
        assertEquals(note.content, dto.content)
        assertEquals(note.colorIndex, dto.colorIndex)
    }
}