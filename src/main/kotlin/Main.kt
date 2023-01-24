import data.Comment
import data.Note

fun main(args: Array<String>) {
    val serviceNote = service.NoteService
    val serviceComment = service.CommentService
    val userId:Long = 1
    serviceNote.add(Note(0L, userId,false,"title note 1", "text note 1",System.currentTimeMillis(),0,0, "all", "all",true, ""))
    serviceNote.add(Note(0L, userId,false,"title note 2", "text note 2",System.currentTimeMillis(),0,0, "all", "all",true, ""))
    println(serviceNote.elements)

    println("Поиск: " + serviceNote.getById(1))
    println("Поиск: " + serviceNote.getById(4))

    println(serviceNote.update(1,Note(1, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, "")))

    println(serviceNote.delete(2))
    println(serviceNote.elements)

    println(serviceNote.get(1))
    println(serviceNote.get(2))

    serviceComment.add(Comment(0, userId, false,"comment 1  for note 1",1))
    serviceComment.add(Comment(0, userId, false,"comment 2 for note 1",1))
    // подумать как реализовать добавление если нет заметки
    //serviceComment.add(Comment(0, userId, false,"comment 2 for note 1",3))

    println(serviceComment.elements)

    println("Поиск: " + serviceComment.getById(1))

    println(serviceComment.update(1,Comment(1, userId, false,"comment edit 1  for note 1",1)))

    println(serviceComment.delete(2))
    println(serviceComment.get(1))


}