package com.swen3.zooman.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.swen3.zooman.R
import com.swen3.zooman.ui.map.ZooMapsActivity
import com.swen3.zooman.ui.tickets.TicketMasterFragment

class DashboardFragment : Fragment() {

    // Declare var to store parent activity
    lateinit var mActivity: AppCompatActivity;

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_dashboard, root, false);



    return viewRoot




    }






    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Get parent activity from context
        mActivity = context as AppCompatActivity;
    }
}