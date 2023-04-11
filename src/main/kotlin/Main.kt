import model.Archive
import screen.*

val archives = mutableListOf<Archive>()

fun main() {
    var currentScreen: Screen = Screen.ArchiveSelection

    while (true) {
        currentScreen = when (currentScreen) {
            is Screen.ArchiveSelection -> showArchiveSelection()
            is Screen.ArchiveCreation -> showArchiveCreation()
            is Screen.NoteSelection -> showNoteSelection(currentScreen.archiveName)
            is Screen.NoteCreation -> showNoteCreation(currentScreen.archiveName)
            is Screen.NoteView -> showNoteView(currentScreen.archiveName, currentScreen.noteTitle)
        }
    }
}