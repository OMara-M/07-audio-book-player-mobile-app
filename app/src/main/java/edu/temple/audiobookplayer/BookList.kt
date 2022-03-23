package edu.temple.audiobookplayer

class BookList (private val _books:ArrayList<Book>){

    fun add(book:Book): Unit {
        _books.add(book)
    }

    fun remove(book:Book): Unit{
        _books.remove(book)
    }

    fun get(bookID: Int): Book {
        return _books[bookID]
    }

    fun size(): Int {
        return _books.size
    }
}