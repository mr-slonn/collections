import data.Comment
import data.Note
import service.ServiceException

fun main(args: Array<String>) {
    val serviceNote = service.NoteService
    val serviceComment = service.CommentService
    val userId:Long = 1
    serviceNote.add(Note(0L, userId,false,"title note 1", "text note 1",System.currentTimeMillis(),0,0, "all", "all",true, ""))
    serviceNote.add(Note(0L, userId,false,"title note 2", "text note 2",System.currentTimeMillis(),0,0, "all", "all",true, ""))
    println("Список заметок:")
    for (elem in serviceNote.elements)
    {
        println(elem)
    }

    println("Получить заметку c id=1: ${serviceNote.getById(1) ?: "Не найден"}")
    println("Получить заметку с id=4: ${serviceNote.getById(4) ?: "Не найден"}")

    println("Обновляем заметку с id=1:")
    println("Заметка была: ")
    println(serviceNote.getById(1))
    if (serviceNote.update(1,Note(1, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, "")))
    {
        println("Успешное обновление заметки")
    }
    println("Заметка стала: ")
    println(serviceNote.getById(1))

    if (serviceNote.update(1,Note(2, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, "")))
    {
        println("Не успешное обновление заметки")
    }

    println("Удаляем заметки")
    if (serviceNote.delete(2)) {
        println("Заметка успешно удалена, текущий список заметок:")
        for (elem in serviceNote.elements) {
            println(elem)
        }
    }

    println("Обновляем заметку с id=2 (удаленная):")
    try {
        println(serviceNote.update(2,Note(2, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, "")))
    }
    catch (ex: ServiceException)
    {
        println(ex)
    }

    println("Получаем заметки пользователя id=2:")
    for (elem in serviceNote.get(1))
    {
        println(elem)
    }


    if (serviceNote.get(2).isEmpty())
    {
        println("У пользователя id=2 нет заметок")
    }


    serviceComment.add(Comment(0, userId, false,"comment 1  for note 1",1))
    serviceComment.add(Comment(0, userId, false,"comment 2 for note 1",1))

    println("Список комментариев:")
    for (elem in serviceComment.elements)
    {
        println(elem)
    }

    println("Получить заметку c id=1: ${serviceComment.getById(1) ?: "Не найден комментарий"}")
    println("Получить заметку c id=1: ${serviceComment.getById(3) ?: "Не найден комментарий"}")



    println("Обновляем комментарий с id=1:")
    println("Комментарий был: ")
    println(serviceComment.getById(1))
    if (serviceComment.update(1,Comment(1, userId, false,"comment edit 1  for note 1",1)))
    {
        println("Успешное обновление заметки")
    }
    println("Комментарий стал: ")
    println(serviceComment.getById(1))

    println(serviceComment.delete(2))
    println("Получить удалённый для восстановления")
    println(serviceComment.getById(2,true))
    println("Получить удалённый просто так")
    try {
        println(serviceComment.getById(2))
    }
    catch (ex: ServiceException)
    {
        println(ex)
    }
    println("Восстановить удалённый комментарий")
    serviceComment.restoreComment(2)
    println(serviceComment.getById(2))

    println("Получаем комментарии пользователя id=2:")
    for (elem in serviceNote.get(1))
    {
        println(elem)
    }


    if (serviceNote.get(2).isEmpty())
    {
        println("У пользователя id=2 нет комментариев")
    }


}