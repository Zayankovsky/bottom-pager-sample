package com.yandex.mobile.bottompager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class MainAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val currentList = listOf(19, 17, 15, 13, 11)

    override fun createFragment(position: Int): Fragment {
        return MainFragment.create(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
