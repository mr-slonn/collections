package data

class Comment(
    // Идентификатор.
    id: Long,
    // Идентификатор владельца.
    ownerId: Long,
    isDeleting: Boolean,
    private val message: String,
    noteId: Long,
    // Статус удаленного

) : Item(id, ownerId, isDeleting) {
    override fun toString(): String {
        return "id=$id ownerId=$ownerId isDeleting=$isDeleting  message=$message"
    }
}