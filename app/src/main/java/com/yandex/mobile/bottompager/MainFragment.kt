package com.yandex.mobile.bottompager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    private val childCount by lazy { requireArguments().getInt(keyChildCount) }

    private lateinit var scroll: NestedScrollView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        scroll = view.findViewById(R.id.scroll)
        val content = scroll.findViewById<ViewGroup>(R.id.content)
        repeat(childCount) { inflater.inflate(R.layout.text_main, content) }
        return view
    }

    override fun onResume() {
        super.onResume()
        scroll.isNestedScrollingEnabled = true
        (requireActivity() as MainActivity).scrollingPage = scroll
    }

    override fun onPause() {
        scroll.isNestedScrollingEnabled = false
        super.onPause()
    }

    companion object {

        private const val keyChildCount = "childCount"

        fun create(childCount: Int): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply { putInt(keyChildCount, childCount) }
            }
        }
    }
}