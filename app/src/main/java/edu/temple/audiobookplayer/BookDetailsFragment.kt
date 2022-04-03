package edu.temple.audiobookplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class BookDetailsFragment : Fragment() {

    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_details, container, false)

        titleTextView = layout.findViewById(R.id.titleTextView)
        titleTextView = layout.findViewById(R.id.authorTextView)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
            .getSelectedBook().observe(requireActivity()) {update(it)}
    }

    private fun update(book: Book?) {
        book?.run {
            titleTextView. text = title
            authorTextView. text = author
        }
    }
}