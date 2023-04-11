package screen

import archives
import kotlin.system.exitProcess

fun showArchiveSelection(): Screen {
    while (true) {
        println("\nСписок архивов:")
        println("0. Создать архив")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }
        println("${archives.size + 1}. Выход")

        val input = readLine()
        val choice = input?.toIntOrNull()

        when {
            choice == null -> println("Введите цифру.")
            choice == 0 -> return Screen.ArchiveCreation
            choice in 1..archives.size -> return Screen.NoteSelection(archives[choice - 1].name)
            choice == archives.size + 1 -> exitProcess(0)
            else -> println("Нет такого пунктаю")
        }
    }
}