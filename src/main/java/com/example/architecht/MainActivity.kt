package com.example.architecht


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAddData.setOnClickListener(){

            val intent = Intent(
                this,
                AddDataActivity::class.java
            )
            // start your next activity
            startActivity(intent)

        }

        btnListData.setOnClickListener(){

            val intent = Intent(
                this,
                listItemsActivity::class.java
            )
            // start your next activity
            startActivity(intent)
        }

    }

}
