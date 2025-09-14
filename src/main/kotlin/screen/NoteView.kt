package screen

import archives

fun showNoteView(archiveName: String, noteTitle: String): Screen {
    val archive = archives.find { it.name == archiveName } ?: return Screen.ArchiveSelection
    val note = archive.notes.find { it.title == noteTitle } ?: return Screen.NoteSelection(archiveName)

    println("\nЗаметка: ${note.title}")
    println(note.content)
    println("\n0. Назад")

    while (true) {
        val input = readLine()
        if (input == "0") return Screen.NoteSelection(archiveName)
        else println("Введите 0 для возврата.")
    }
}