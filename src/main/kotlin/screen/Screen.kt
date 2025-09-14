package screen

sealed class Screen {
    object ArchiveSelection : Screen()
    object ArchiveCreation : Screen()
    data class NoteSelection(val archiveName: String) : Screen()
    data class NoteCreation(val archiveName: String) : Screen()
    data class NoteView(val archiveName: String, val noteTitle: String) : Screen()
}