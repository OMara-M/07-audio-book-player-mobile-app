package edu.temple.audiobookplayer

import android.os.Build
import android.os.Parcel
import android.os.Parcelable

class BookList () : Parcelable{

    private val books : MutableList<Book> by lazy {
        ArrayList()
    }

    constructor(parcel: Parcel) : this() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.readParcelableList(books,null)
        }
    }

    fun add(book:Book): Unit {
        books.add(book)
    }

    fun remove(book:Book): Unit{
        books.remove(book)
    }


    operator fun get(bookID: Int): Book {
        return books[bookID]
    }

    fun size(): Int {
        return books.size
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeParcelableList(books,flags)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookList> {
        override fun createFromParcel(parcel: Parcel): BookList {
            return BookList(parcel)
        }

        override fun newArray(size: Int): Array<BookList?> {
            return arrayOfNulls(size)
        }
    }
}