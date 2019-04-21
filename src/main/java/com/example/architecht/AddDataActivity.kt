package com.example.architecht

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_data.*
import java.util.*

class AddDataActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        database = FirebaseDatabase.getInstance().reference

        btnSaveToDatabase.setOnClickListener(){
            var uniqueID = UUID.randomUUID().toString()
            writeNewUser(uniqueID,editTextInput.text.toString().trim())
            val intent = Intent(
                this,
                listItemsActivity::class.java
            )
            // start your next activity
            startActivity(intent)
        }
    }

    private fun writeNewUser(userId: String, name: String) {

        val user = User()
        user.name=name
        database.child("architecht").child(userId).setValue(user)
    }
}
