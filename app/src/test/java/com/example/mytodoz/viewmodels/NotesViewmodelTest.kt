package com.example.mytodoz.viewmodels

import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.models.Note
import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.usecase.GetAllNotesUseCase
import com.example.mytodoz.domain.usecase.GetNoteByIdUseCase
import com.example.mytodoz.domain.usecase.NoteUseCases
import com.example.mytodoz.viewModels.NotesViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FakeRepoSuccess(): NoteRepository {
    override suspend fun getAllNotes(): List<NoteDto> {
        return listOf(
            NoteDto(1, "Note 1", "Content 1"),
            NoteDto(2, "Note 2", "Content 2"),
            NoteDto(3, "Note 3", "Content 3"),
        )
    }
    override suspend fun getById(id: Int): Note? = Note(0, "Note title", "Note content")
    override fun addNote(note: Note) {}
    override fun deleteNote(note: Note): Boolean = true
    override fun update(updateNote: Note) {}
}

// FakeRepoFailure


class NotesViewmodelTest {

    private fun buildUseCases(repo: NoteRepository) = NoteUseCases(
        getAllNotes = GetAllNotesUseCase(repo),
        getNoteById = GetNoteByIdUseCase(repo)
    )

    @Test
    fun `fetchNotesFromRepo should populate remoteNotes`() {
        // Arrange
        // 1- Create Fake repository that implements NoteRepository interface ✅
        val fakeRepoSuccess = FakeRepoSuccess()
        // 2- Create GetAllNotesUseCase instance ✅
        // 3- Create NoteUseCases ✅
        val useCases = buildUseCases(fakeRepoSuccess)

        // 4- Create NotesViewModel
        val noteVm = NotesViewModel(useCases) // init()

        // Act
        val notes = noteVm.remoteNotes.value

        // Assert
        assertEquals(notes.size, 3)
        assertEquals(notes[1].title, "Note 1")
    }

}