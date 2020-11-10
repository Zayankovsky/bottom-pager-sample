package com.yandex.mobile.bottompager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val coordinator by lazy { findViewById<ViewGroup>(R.id.coordinator) }

    var scrollingPage: View? = null
        set(value) {
            if (field == value) return
            field = value
            coordinator.doOnPreDraw { it.requestLayout() }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pager = coordinator.findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MainAdapter(fragmentActivity = this)
        pager.children.filterIsInstance(RecyclerView::class.java).first().isNestedScrollingEnabled = false

        val behavior = BottomSheetBehavior.from(pager)
        behavior.isHideable = true
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        findViewById<View>(R.id.text).setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}