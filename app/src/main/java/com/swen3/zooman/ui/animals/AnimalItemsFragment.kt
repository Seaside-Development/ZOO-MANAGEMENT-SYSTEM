package com.swen3.zooman.ui.animals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swen3.zooman.R
import java.util.*


/**
 * A fragment representing a list of Items.
 */
class AnimalItemsFragment : Fragment() {

    private var columnCount = 1
    lateinit var mActivity: AppCompatActivity;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = 1
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_item_list, container, false)

        //val animals = mActivity.resources.getStringArray(R.array.animals);
        val myArrayList: List<String> = Arrays.asList(*resources.getStringArray(R.array.animals))

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = AnimalItemRecyclerViewAdapter(myArrayList)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity;
    }
}