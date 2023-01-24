package data

 class Note(
    // Идентификатор заметки.
     id: Long,
    // Идентификатор владельца заметки.
     ownerId: Long,
     // Статус удаленного
     isDeleting : Boolean,
    // Заголовок заметки.
     private val title: String,
    // Текст заметки.
     private val text: String,
    // Дата создания заметки в формате Unixtime.
     date: Long,
    // Количество комментариев.
     val  comments: Int,
    // Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
     val   readComments: Int,
    // URL страницы для отображения заметки.
    // viewUrl: String,
    // Настройки приватности просмотра заметки
     val  privacyView: String,
    // Настройки приватности комментирования заметки
     val  privacyComment: String,
    // Есть ли возможность оставлять комментарии
     val  canComment: Boolean,
    // Тэги ссылок на wiki
     val  textWiki: String,

     ):Item(id,ownerId, isDeleting) {
     override fun toString(): String {
         return "id=$id isDeleting=$isDeleting ownerId=$ownerId title=$title text=$text"
     }
 }
