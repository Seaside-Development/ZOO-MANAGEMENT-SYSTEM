package com.amier.modernloginregister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ScrollingFragmentDashboard : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_scrolling_dashboard, root, false);

        return viewRoot
    }
}