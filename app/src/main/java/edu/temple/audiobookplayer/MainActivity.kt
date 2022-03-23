package edu.temple.audiobookplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val books = createBookList()


    }

    private fun createBookList(): BookList{
        val books = BookList()
        val titles = resources.getStringArray(R.array.titles)
        val authors = resources.getStringArray(R.array.authors)
        books.add(Book(titles[0],authors[0]))
        books.add(Book(titles[1],authors[1]))
        books.add(Book(titles[2],authors[2]))
        books.add(Book(titles[3],authors[3]))
        books.add(Book(titles[4],authors[4]))
        books.add(Book(titles[5],authors[5]))
        books.add(Book(titles[6],authors[6]))
        books.add(Book(titles[7],authors[7]))
        books.add(Book(titles[8],authors[8]))
        books.add(Book(titles[9],authors[9]))
        return books
    }
}