package com.example.spinnerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.spinnerdemo.R.id.spinnerCourseSelection

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. create object to hold spinner
        val spinnerSelection: Spinner = findViewById(R.id.spinnerCourseSelection)
        spinnerSelection.onItemSelectedListener=this

        //2. create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.course_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            //specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //apply the adapter to the spinner
            spinnerSelection.adapter = adapter


        }


    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long){
        //an item was selected. you can retrieve the selected item using parent.getItemAtPosition(pos)
        val selectionTv:TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text = parent.getItemAtPosition(pos).toString()

    }

    override fun onNothingSelected (parent: AdapterView<*>){
        //another interface callback
        val selectionTv : TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text ="You have not made a course selection"

    }


}