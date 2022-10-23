package com.example.midtrempr

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
* Aviraj Gill
* Midterm shopping list
* This app allows you to make a shopping list up to five items and save them to a LOG
* 2022-10-20
 */

class MainActivity : AppCompatActivity() {

    var inputBoxListName: TextView? = null
    var inputBoxListItem: TextView? = null
    var breakPointText: TextView? = null
    var emptyStringValue:  String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputBoxListName = findViewById(R.id.inputListName);
        inputBoxListItem = findViewById(R.id.inputItemName);
        breakPointText = findViewById(R.id.breakPoiunt);
        emptyStringValue = getString(R.string.row1)
        findViewById<Button>(R.id.saveButton).setOnClickListener { onSaveClick(); }
        findViewById<Button>(R.id.cancelButton).setOnClickListener { onCancelClick(); }

    }
    //Array of all rows
    private val rowArray = arrayOf(

        R.id.rowItem1,
        R.id.rowItem2,
        R.id.rowItem3,
        R.id.rowItem4,
        R.id.rowItem5
    )
    //Array of the qty boxes next to row
    private val qtyArray = arrayOf(

        R.id.qty1,
        R.id.qty2,
        R.id.qty3,
        R.id.qty4,
        R.id.qty5
    )
    private fun getListName() : String//Gets list name
    {
        return inputBoxListName?.text.toString();
    }
    private fun getItemName() : String//Gets item names
    {
        return inputBoxListItem?.text.toString();
    }
    private fun resetInputBox()//Resets the item box after click
    {
        inputBoxListItem?.text = "";
        inputBoxListName?.text = "";
    }
    private fun onSaveClick()//When the saves button is clicked
    {
        //only add text to rows if item is inputted
        if(getListName().isNotEmpty()) {
            breakPointText?.text = getListName();
        }
        //Add input to row
        addTextToRow(getListName());
        resetInputBox();//Reset the boxes
        displayToLog();//Add to log
    }
    private fun onCancelClick()// ON cancel reset all values
    {
        //Runs in the loop to set value back to normal
        for (i in 0..4)
        {
            val row : TextView = findViewById(rowArray[i])
            row.text = emptyStringValue
        }

    }

    //Functions to add to the list
    private fun addTextToRow(s : String)
    {
        //only add text to rows if item is inputted
        if(getItemName().isEmpty())
            return;

        //For loop to check for a Empty spot
        for (i in 0..4)
        {
            val row : TextView = findViewById(rowArray[i])
            if(row.text.toString() == emptyStringValue)
            {
                //If found replace that with the item name
                row.text = getItemName();
                break;
            }
        }
    }

    //Functions to display into logs
    private fun displayToLog()
    {
        //Runs in the loop to set value back to normal
        for (i in 0..4)
        {
            val row : TextView = findViewById(rowArray[i])
            val qty : TextView = findViewById(qtyArray[i])

            Log.i("Display Value (row)", row.text.toString());
            Log.i("Display Value (qty)", qty.text.toString());
        }
    }
}