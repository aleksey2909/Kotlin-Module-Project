package screen

import archives

fun showNoteSelection(archiveName: String): Screen {
    val archive = archives.find { it.name == archiveName} ?: return Screen.ArchiveSelection

    while (true) {
        println("\nАрхив: $archiveName")
        println("0. Создать заметку")
        archive.notes.forEachIndexed { index, note ->
            println("${index + 1}. ${note.title}")
        }
        println("${archive.notes.size + 1}. Назад")

        val input = readLine()
        val choice = input?.toIntOrNull()

        when {
            choice == null -> println("Введите цифру.")
            choice == 0 -> return Screen.NoteCreation(archiveName)
            choice in 1..archive.notes.size -> return Screen.NoteView(archiveName, archive.notes[choice - 1].title)
            choice == archive.notes.size + 1 -> return Screen.ArchiveSelection
            else -> println("Нет такого пункта.")
        }
    }
}