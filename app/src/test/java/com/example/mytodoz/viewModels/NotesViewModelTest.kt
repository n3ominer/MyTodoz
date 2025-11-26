package com.example.mytodoz.viewModels

import androidx.compose.runtime.ExperimentalComposeApi
import com.example.mytodoz.MainDispatcherRule
import com.example.mytodoz.data.remote.models.NoteDto
import com.example.mytodoz.domain.models.Note
import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.usecase.GetAllNotesUseCase
import com.example.mytodoz.domain.usecase.GetNoteByIdUseCase
import com.example.mytodoz.domain.usecase.NoteUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


// Create FakeRepoSuccess

class FakeRepoSuccess: NoteRepository {
    override suspend fun getAllNotes(): List<NoteDto> {
        return listOf(
            NoteDto(0, "Note 1", "Note 1 content"),
            NoteDto(1, "Note 2", "Note 2 content"),
            NoteDto(2, "Note 3", "Note 3 content"),
        )
    }

    override suspend fun getById(id: Int): Note?  = Note(id, "Note title", "Note content")
    override fun addNote(note: Note) { }
    override fun deleteNote(note: Note): Boolean = true
    override fun update(updateNote: Note) { }

}

// Create FakeRepoFailure
class FakeRepoFailure: NoteRepository {
    override suspend fun getAllNotes(): List<NoteDto> = emptyList()
    override suspend fun getById(id: Int): Note? = null
    override fun addNote(note: Note) {}
    override fun deleteNote(note: Note): Boolean = false
    override fun update(updateNote: Note) {}
}


@OptIn(ExperimentalCoroutinesApi::class)
class NotesViewModelTest {

    // Setup Async behavior
    @get:Rule
    val mainDispatcher = MainDispatcherRule()

    // Create UseCases
    private fun buildUseCases(repo: NoteRepository) = NoteUseCases(
        getAllNotes = GetAllNotesUseCase(repo),
        getNoteById = GetNoteByIdUseCase(repo)
    )


    @Test
    fun `fetchNotesFromRepo func should successfully populate noteRepo`() = runTest{
        // Arrange
        val repoSuccess = FakeRepoSuccess()
        val useCases = buildUseCases(repoSuccess)
        val vm = NotesViewModel(useCases)

        advanceUntilIdle()
        // Act
        val notes = vm.remoteNotes.value

        // Assert
        assertEquals(notes.size, 3)
        assertEquals(notes[0].title, "Note 1")
    }

    // Test de la fun fetchNotesFromRepo en cas de failure


    // Test de la fun getNoteById en cas de succes

    // Test de la fun getNoteById en cas de failure
  
}