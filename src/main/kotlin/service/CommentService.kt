package service

import data.Comment


object CommentService: CrudService<Comment>() {



    fun restoreComment(id:Long):Boolean
    {
        val comment = this.getById(id,true)
        if (comment!=null)
        {
            comment.isDeleting = false
            return true
        }
        return  false
    }

}