import com.example.mytodoz.domain.usecase.GetAllNotesUseCase
import com.example.mytodoz.domain.usecase.GetNoteByIdUseCase

/**
 * Aggregation of all note-related use cases.
 * Construct this in the composition root (e.g., `MainActivity`) and pass to ViewModels.
 */
data class NoteUseCases(
	val getAllNotes: GetAllNotesUseCase,
	val getNoteById: GetNoteByIdUseCase,
)

