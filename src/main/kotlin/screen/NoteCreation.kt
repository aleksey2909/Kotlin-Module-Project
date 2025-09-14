package screen

import archives
import model.Note

fun showNoteCreation(archiveName: String): Screen {
    val archive = archives.find { it.name == archiveName } ?: return Screen.ArchiveSelection

    println("\nВведите заголовок заметки:")
    val title = readLine()?.trim().orEmpty()
    println("Введите текст заметки:")
    val content = readLine()?.trim().orEmpty()

    if (title.isNotEmpty()) {
        archive.notes.add(Note(title, content))
        println("Заметка \"$title\" добавлена.")
    } else {
        println("Заголовок не может быть пустым.")
    }

    return Screen.NoteSelection(archiveName)
}
