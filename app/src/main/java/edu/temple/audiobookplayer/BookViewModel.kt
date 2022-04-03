package edu.temple.audiobookplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    private val book: MutableLiveData<Book> by lazy {
        MutableLiveData()
    }

    fun getSelectedBook(): LiveData<Book> {
        return book
    }

    fun setSelectedBook(Book: Book?) {
        this.book.value = Book
    }
}