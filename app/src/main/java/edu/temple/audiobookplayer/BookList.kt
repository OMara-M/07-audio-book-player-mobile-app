package edu.temple.audiobookplayer

class BookList (){
private val books = arrayListOf<Book>()


    fun add(book:Book): Unit {
        books.add(book)
    }

    fun remove(book:Book): Unit{
        books.remove(book)
    }

    fun get(bookID: Int): Book {
        return books[bookID]
    }

    fun size(): Int {
        return books.size
    }
}