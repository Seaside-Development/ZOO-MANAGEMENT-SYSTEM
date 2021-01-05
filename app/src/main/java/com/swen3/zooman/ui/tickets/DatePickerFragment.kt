package com.swen3.zooman.ui.tickets

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.swen3.zooman.R
import java.util.*

class DatePickerFragment : DialogFragment() {
    private var mDatePicker: DatePicker? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val date = requireArguments().getSerializable(ARG_DATE) as Date?
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        val v = LayoutInflater.from(activity)
            .inflate(R.layout.dialog_date, null)
        mDatePicker = v.findViewById<View>(R.id.date_picker) as DatePicker
        mDatePicker!!.init(year, month, day, null)
        val mSetTime = v.findViewById<View>(R.id.time_set) as Button
        mSetTime.setOnClickListener {
            val tp1 = TimePickerDialog(context, { view, hourOfDay, minute ->
                calendar[Calendar.HOUR_OF_DAY] = hourOfDay
                calendar[Calendar.MINUTE] = minute
            }, calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], true)
            tp1.show()
        }
        return AlertDialog.Builder(activity)
            .setView(v)
            .setTitle(R.string.date_picker_title)
            .setPositiveButton(
                android.R.string.ok
            ) { dialog, which ->
                val year = mDatePicker!!.year
                val month = mDatePicker!!.month
                val day = mDatePicker!!.dayOfMonth
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val date = GregorianCalendar(year, month, day, hour, minute).time
                sendResult(Activity.RESULT_OK, date)
            }
            .create()
    }

    private fun sendResult(resultCode: Int, date: Date) {
        if (targetFragment == null) {
            return
        }
        val intent = Intent()
        intent.putExtra(EXTRA_DATE, date)
        targetFragment!!
            .onActivityResult(targetRequestCode, resultCode, intent)
    }

    companion object {
        const val EXTRA_DATE = "com.swen3.zooman.ui.tickets.date"
        private const val ARG_DATE = "date"
        fun newInstance(date: Date?): DatePickerFragment {
            val args = Bundle()
            args.putSerializable(ARG_DATE, date)
            val fragment = DatePickerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}