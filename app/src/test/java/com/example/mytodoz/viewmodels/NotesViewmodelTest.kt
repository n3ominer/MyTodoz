package com.example.mytodoz.viewmodels

import com.example.mytodoz.MainDispatcherRule
import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.models.Note
import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.usecase.GetAllNotesUseCase
import com.example.mytodoz.domain.usecase.GetNoteByIdUseCase
import com.example.mytodoz.domain.usecase.NoteUseCases
import com.example.mytodoz.viewModels.NotesViewModel
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
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

class FakeRepoFailure(): NoteRepository {
    override suspend fun getAllNotes(): List<NoteDto> { throw RuntimeException("ERROR") }
    override suspend fun getById(id: Int): Note? = null
    override fun addNote(note: Note) {}
    override fun deleteNote(note: Note): Boolean  = false
    override fun update(updateNote: Note) {}
}


class NotesViewmodelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private fun buildUseCases(repo: NoteRepository) = NoteUseCases(
        getAllNotes = GetAllNotesUseCase(repo),
        getNoteById = GetNoteByIdUseCase(repo)
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `fetchNotesFromRepo should populate remoteNotes`() = runTest {
        // Arrange
        // 1- Create Fake repository that implements NoteRepository interface ✅
        val fakeRepoSuccess = FakeRepoSuccess()
        // 2- Create GetAllNotesUseCase instance ✅
        // 3- Create NoteUseCases ✅
        val useCases = buildUseCases(fakeRepoSuccess)

        // 4- Create NotesViewModel
        val noteVm = NotesViewModel(useCases) // init()

        advanceUntilIdle()

        // Act
        val notes = noteVm.remoteNotes.value

        // Assert
        assertEquals(3, notes.size )
        assertEquals("Note 1", notes[0].title)
    }


    @Test
    fun `fetchNotesFromRepo should throw error and create an error`() = runTest {
        // Arrange
        // 1- Create Fake repository that implements NoteRepository interface ✅
        val fakeRepoFailure = FakeRepoFailure()
        // 2- Create GetAllNotesUseCase instance ✅
        // 3- Create NoteUseCases ✅
        val useCases = buildUseCases(fakeRepoFailure)

        // 4- Create NotesViewModel
        val noteVm = NotesViewModel(useCases) // init()

        advanceUntilIdle()

        // ACT
        val expectedErrorMessage = "Erreur de chargement des données. Error: ERROR"

        // Assert
        assertTrue(noteVm.remoteNotes.value.isEmpty())
        assertNotNull(noteVm.error)
        assertEquals(expectedErrorMessage, noteVm.error.value)
    }

}