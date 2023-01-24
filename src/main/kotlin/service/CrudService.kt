package service

import data.Item

open class CrudService<T : Item> {
    private var id = 1L
    var elements = mutableListOf<T>()

    fun clear()
    {
        id =1
        elements = mutableListOf<T>()
    }
    fun add (elem:T):Long{
        elem.id = id++
        elements += elem
        return elements.last().id
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
                    update.id=id
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

    fun getById(id:Long, isDeleting:Boolean=false):T?
    {
        for (elem in elements) {
            if (elem.id == id) {

                if (elem.isDeleting && !isDeleting) {
                    throw ServiceException("Попытка получения удалённого элемента")
                }
                else {
                    return elem
                }
            }
        }
        return null
    }

    fun get(userId:Long) : MutableList<T> {
        val results = mutableListOf<T>()
        for (elem in elements) {
            if (elem.ownerId == userId && !elem.isDeleting) {
                results.add(elem)
            }
        }

        return  results
    }
}