package tests

import data.Note
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import service.ServiceException

class NoteServiceTest {

    @Before
    fun clear()
    {
        val serviceNote = service.NoteService
        serviceNote.clear()
    }

    @Test
    fun add() {

        val serviceNote = service.NoteService
        val userId: Long = 1

        Assert.assertEquals(
            1,
            serviceNote.add(
                Note(
                    0L,
                    userId,
                    false,
                    "title note 1",
                    "text note 1",
                    System.currentTimeMillis(),
                    0,
                    0,
                    "all",
                    "all",
                    true,
                    ""
                )
            )
        )
    }


    @Test
    fun update() {
        val serviceNote = service.NoteService
        val userId: Long = 1

        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )

        assertTrue(
            serviceNote.update(
                1,
                Note(
                    1,
                    userId,
                    false,
                    "title note edit 1",
                    "text note edit 1",
                    System.currentTimeMillis(),
                    0,
                    0,
                    "all",
                    "all",
                    true,
                    ""
                )
            )
        )
    }

    @Test
    fun updateFalse() {
        val serviceNote = service.NoteService
        val userId: Long = 1
        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )


        assertFalse(
            serviceNote.update(2,Note(1, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, ""))
        )

    }

    @Test(expected = ServiceException::class)
    fun updateThrow() {
        val serviceNote = service.NoteService
        val userId: Long = 1
        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )
        serviceNote.delete(1)


            serviceNote.update(1,Note(1, userId,false,"title note edit 1", "text note edit 1",System.currentTimeMillis(),0,0, "all", "all",true, ""))


    }

    @Test
    fun delete() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )


        assertTrue(serviceNote.delete(1))

    }

    @Test
    fun deleteFalse() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )
        assertFalse(serviceNote.delete(3))

    }

    @Test(expected = ServiceException::class)
    fun deleteThrow() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        serviceNote.add(
            Note(
                0L,
                userId,
                false,
                "title note 1",
                "text note 1",
                System.currentTimeMillis(),
                0,
                0,
                "all",
                "all",
                true,
                ""
            )
        )


        serviceNote.delete(1)
        serviceNote.delete(1)

    }


    @Test
    fun getById() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        var resulNote: Note = Note(
            1,
            userId,
            false,
            "title note 1",
            "text note 1",
            1674586860,
            0,
            0,
            "all",
            "all",
            true,
            ""
        )
        serviceNote.add(
            resulNote
        )



        Assert.assertEquals(resulNote, serviceNote.getById(1))
    }

    @Test
    fun getByIdNull() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        var resulNote: Note = Note(
            1,
            userId,
            false,
            "title note 1",
            "text note 1",
            1674586860,
            0,
            0,
            "all",
            "all",
            true,
            ""
        )
        serviceNote.add(
            resulNote
        )



        Assert.assertEquals(null, serviceNote.getById(2))
    }

    @Test(expected = ServiceException::class)
    fun getByIdThrow() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        var resulNote: Note = Note(
            1,
            userId,
            false,
            "title note 1",
            "text note 1",
            1674586860,
            0,
            0,
            "all",
            "all",
            true,
            ""
        )
        serviceNote.add(
            resulNote
        )


        serviceNote.delete(1)
        serviceNote.getById(1)
    }

    @Test
    fun get() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        var resulNote: Note = Note(
            1,
            userId,
            false,
            "title note 1",
            "text note 1",
            1674586860,
            0,
            0,
            "all",
            "all",
            true,
            ""
        )
        serviceNote.add(
            resulNote
        )

        Assert.assertEquals(serviceNote.elements, serviceNote.get(1))
    }

    @Test
    fun getNotFound() {

        val serviceNote = service.NoteService
        val userId: Long = 1
        var resulNote: Note = Note(
            1,
            userId,
            false,
            "title note 1",
            "text note 1",
            1674586860,
            0,
            0,
            "all",
            "all",
            true,
            ""
        )
        serviceNote.add(
            resulNote
        )

        Assert.assertEquals(mutableListOf<Note>(), serviceNote.get(2))
    }
}