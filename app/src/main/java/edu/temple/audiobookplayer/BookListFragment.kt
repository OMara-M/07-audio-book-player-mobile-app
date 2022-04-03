package edu.temple.audiobookplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val BOOKS = "books"

class BookListFragment : Fragment() {
    private var books: BookList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            books = it.getParcelable(BOOKS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myViewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)

        val onClick: (Book) -> Unit = { book: Book ->
            myViewModel.setSelectedBook(book)
            (activity as BookSelect).bookSelect()
        }
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = BookListAdapter(books!!, onClick)
        }
    }

    companion object {
        fun newInstance(books: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(BOOKS, books)
                }
            }
    }

    interface BookSelect {
        fun bookSelect()
    }
}