package tests

import data.Comment
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import service.ServiceException

class CommentServiceTest {

    @Test
    fun restoreComment() {

        val serviceComment = service.CommentService
        val userId:Long = 1
        serviceComment.add(Comment(0, userId, false,"comment 1  for note 1",1))
        serviceComment.delete(1)
        assertTrue(serviceComment.restoreComment(1))
    }

    @Test
    fun restoreCommentFail() {
        val serviceComment = service.CommentService
        val userId:Long = 1
        serviceComment.add(Comment(0, userId, false,"comment 1  for note 1",1))
        assertFalse(serviceComment.restoreComment(2))
    }
}