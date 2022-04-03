package edu.temple.audiobookplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookListAdapter (_books: BookList, _onClick: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){

    private val books = _books
    private val onClick = _onClick

    class BookViewHolder (layout : View): RecyclerView.ViewHolder (layout) {
        val titleTextView : TextView = layout.findViewById(R.id.titleTextView)
        val authorTextView : TextView = layout.findViewById(R.id.authorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.titleTextView.text = books[position].title
        holder.authorTextView.text = books[position].author
        holder.titleTextView.setOnClickListener {
            onClick(books[position])
        }
    }

    override fun getItemCount(): Int {
        return books.size()
    }
}