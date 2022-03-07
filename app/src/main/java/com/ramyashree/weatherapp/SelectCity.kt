package com.ramyashree.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.*
import android.widget.Toast.*
import androidx.core.content.ContentProviderCompat.requireContext
import java.text.FieldPosition

class SelectCity : AppCompatActivity() {

    val items = listOf("Bangalore,IN","Delhi,IN", "Kolkata,In","Mangalore,IN","Mumbai,IN")
    var loc:String="city"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)

        val btn=findViewById<Button>(R.id.button)

        val act = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, items)
        act.setAdapter(adapter)

        act.onItemClickListener=object:AdapterView.OnItemClickListener{

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                loc= p0?.getItemAtPosition(p2).toString()
                //Toast.makeText(this@SelectCity, loc, Toast.LENGTH_SHORT).show()

            }
        }

        btn.setOnClickListener{
            val i = Intent(this, MainActivity::class.java).apply {
                putExtra("location",loc.toString())
            }

            startActivity(i)
        }

    }
}