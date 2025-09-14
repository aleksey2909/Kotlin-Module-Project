package screen

import archives
import model.Archive

fun showArchiveCreation(): Screen {
    println("\nВведите название новго архива:")
    val name = readLine()?.trim().orEmpty()
    if (name.isNotEmpty()) {
        archives.add(Archive(name))
        println("Архив \"$name\" создан.")
    } else {
        println("Название не может быть пустым.")
    }
    return Screen.ArchiveSelection
}