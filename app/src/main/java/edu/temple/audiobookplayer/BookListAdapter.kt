package edu.temple.audiobookplayer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookListAdapter (_books: BookList, _onClick: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){

    private val books = _books
    private val onClick = _onClick

    class BookViewHolder (layout : View): RecyclerView.ViewHolder (layout) {
        val titleTextView : TextView = layout.findViewById(R.id.titleTextView)
        val authorTextView : TextView = layout.findViewById(R.id.authorTextView)
    }
}