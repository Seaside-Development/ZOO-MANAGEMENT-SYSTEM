package com.amier.modernloginregister

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ScrollingFragmentDashboard : Fragment() {

    // Declare var to store parent activity
    lateinit var mActivity: AppCompatActivity;

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_scrolling_dashboard, root, false);
        val btnChangeFrag = viewRoot.findViewById<Button>(R.id.change_frag)
        val ticketMasterFrag = TicketMasterFragment()
        btnChangeFrag.setOnClickListener {
            // Use parent activity to perform fragment transaction
            mActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.root_container, ticketMasterFrag)
                .commitAllowingStateLoss()
        }
        return viewRoot
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Get parent activity from context
        mActivity = context as AppCompatActivity;
    }
}