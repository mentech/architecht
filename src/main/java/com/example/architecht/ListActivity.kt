package com.example.architecht

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_list.*
import org.json.JSONArray
import java.lang.Math.log
import kotlin.math.log
import com.google.firebase.database.DataSnapshot
import org.json.JSONObject
import org.json.JSONStringer
import java.util.logging.Level.parse


class ListActivity : AppCompatActivity() {

    //private lateinit var listView: ListView
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        database = FirebaseDatabase.getInstance().reference

        database.addValueEventListener(postListener)

        //listView = findViewById(R.id.listOfData)
// 1
       // stItems =val li arrayOfNulls<String>(5)
        //val lst = ArrayList<String>()
        //lst.add("lkjhljhlkjh")
        //lst.add("lkjhljhlkjh")
        //lst.add("lkjhljhlkjh")

        //listItems[0]="lkjhljhlkjh"
        //listItems[1]="lkjhljhlkjh"
        /*listItems[2]="lkjhljhlkjh"
        listItems[3]="lkjhljhlkjh"
        listItems[4]="lkjhljhlkjh"
        val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, lst)
        //listView.adapter = adapter
        //listView.adapter = adapter
        */
    }

    val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {

            //var children = dataSnapshot.child("architecht").children.toList()[0]
            //var arcs = dataSnapshot.child("architecht").children.toList()
            for (item in dataSnapshot.child("architecht").children.toList()){
                var name = item.children.toList()[0].value
            }

            //var grandson = children.children.toList()

            //var res_val = grandson[0].getValue()

            //val jsonList=  JSONObject(hmList.toString())
            //var deneme = jsonList[jsonList.names()[0].toString()].toString().split(":")[1].replace("}", "").replace("\"","")
            //var idArray= jsonList.names()
            //for (i in 0..(idArray.length() - 1)) {
            //    val item = idArray.getJSONObject(i)
            //    val namee=jsonList[item.toString()].toString().split(":")[1].replace("}", "").replace("\"","")
            //}

        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w("Users", "loadPost:onCancelled", databaseError.toException())
            // ...
        }
    }
}
