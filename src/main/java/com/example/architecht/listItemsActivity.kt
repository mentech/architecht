package com.example.architecht

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.database.*


class listItemsActivity : AppCompatActivity() {
    public  var listItem:MutableList<String> = ArrayList()
    val list: ArrayList<String> = ArrayList()
    private lateinit var database: DatabaseReference
    private lateinit var listView: ListView

    lateinit var adapter: ArrayAdapter<String>
    /* var adapter:ArrayAdapter<String> // ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem) */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)
        database = FirebaseDatabase.getInstance().reference


/*
        listItem[0] = ("lkjhljhlkjh")
        listItem[1] = ("lkjhljhlkjh")
        listItem[2] = ("lkjhljhlkjh")
        listItem[3] = ("lkjhljhlkjh")
        listItem[4] = ("lkjhljhlkjh")
*/
        database.addValueEventListener(postListener)



        listView = findViewById(R.id.listViewUserData)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem)

        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    fun CheckDb(dataSnapshot: DataSnapshot) {
        //listItem=arrayListOf<String>(dataSnapshot.child("architecht").children.count())

        //var children = dataSnapshot.child("architecht").children.toList()[0]
        //var arcs = dataSnapshot.child("architecht").children.toList()
        var i=0
        listItem.clear()
        for (item in dataSnapshot.child("architecht").children.toList()){
            //var name = item.children.toList()[0].value
            listItem.add((item.children.toList()[0].value).toString())
            i+=1
        }

        adapter.notifyDataSetChanged()
    }
    val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            CheckDb(dataSnapshot)
            var dat=listItem

            listView.refreshDrawableState()

        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w("Users", "loadPost:onCancelled", databaseError.toException())
            // ...
        }
    }

}
