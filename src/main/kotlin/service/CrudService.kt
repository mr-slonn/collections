package service

import data.Item

open class CrudService<T : Item> {
    private var id = 1L
    val elements = mutableListOf<T>()
    fun add (elem:T):T{
        elem.id = id++
        elements += elem
        return elements.last()
    }

    fun update(id:Long, update:T):Boolean {
        for ((index,elem) in elements.withIndex())
        {
            if (elem.id == id)
            {
                if (elem.isDeleting) {
                    throw ServiceException("Попытка редактирования удалённого элемента")
                }
                else {
                    elements[index] = update
                    return true
                }
            }
        }
        return false
    }

    fun delete(id:Long):Boolean {
        for ((index,elem) in elements.withIndex())
        {
            if (elem.id == id)
            {
                if (elem.isDeleting) {
                    throw ServiceException("Попытка удаления удалённого элемента")
                }
                else {
                
                    elements[index].isDeleting = true
                    return true
                }
            }
        }
        return false
    }

    fun getById(id:Long):T?
    {
        for (elem in elements) {
            if (elem.id == id) {

                return elem
            }
        }
        return null
    }

    fun get(userId:Long) : MutableList<T> {
        val results = mutableListOf<T>()
        for (elem in elements) {
            if (elem.ownerId == userId) {
                results.add(elem)
            }
        }
        return  results
    }
}