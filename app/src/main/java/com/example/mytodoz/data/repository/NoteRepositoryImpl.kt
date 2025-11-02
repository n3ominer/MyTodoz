package com.example.mytodoz.data.repository

import com.example.mytodoz.domain.repository.NoteRepository
import com.example.mytodoz.domain.models.Note

class NoteRepositoryImpl() : NoteRepository {

    private val notes = mutableListOf(
        Note(1, "Hello World!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit...", colorIndex = 0),
        Note(2, "Work Meeting Notes", "Discussed progress on project X, deadlines, and...", colorIndex = 1),
        Note(3, "Class Notes", "Lecture on Biology: DNA structure and replication...", colorIndex = 2),
        Note(4, "Project Plan", "Research, design, implementation, testing, deployment", colorIndex = 1),
        Note(5, "To-Do List", "Finish homework, call the dentist, buy groceries...", colorIndex = 2),
        Note(1, "Hello World!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit...", colorIndex = 0),
        Note(2, "Work Meeting Notes", "Discussed progress on project X, deadlines, and...", colorIndex = 1),
        Note(3, "Class Notes", "Lecture on Biology: DNA structure and replication...", colorIndex = 2),
        Note(4, "Project Plan", "Research, design, implementation, testing, deployment", colorIndex = 1),
        Note(5, "To-Do List", "Finish homework, call the dentist, buy groceries...", colorIndex = 2),
    )

    override fun getAllNotes(): List<Note> {
        return notes
    }

    override fun getById(id: Int): Note? = notes.find { it.id == id }

    override fun addNote(note: Note) = notes.add(note)

    override fun deleteNote(note: Note): Boolean {
        notes.removeIf {
            it.id == note.id
        }

        return true
    }

    override fun update(updateNote: Note) {
        val index = notes.indexOfFirst { it.id == updateNote.id }
        if (index >= 0) {
            notes[index] = updateNote
        }
    }
}