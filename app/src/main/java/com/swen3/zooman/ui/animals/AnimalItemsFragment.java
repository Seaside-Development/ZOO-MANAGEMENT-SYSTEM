package com.swen3.zooman.ui.animals;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.swen3.zooman.R;
import com.swen3.zooman.database.DataBaseHelper;


/**
 * A fragment representing a list of Items.
 */
class AnimalItemsFragment extends Fragment{
    DataBaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_animal_item);

        db = new DataBaseHelper(this);

    }

    private void setContentView(int fragment_animal_item) {
    }


}