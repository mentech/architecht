package com.example.architecht;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ViewDatabase<postListener> extends AppCompatActivity {
    private static final String TAG="ViewDatabase";

    private ListView myListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database_layout);

        myListView=(ListView)findViewById(R.id.ListViewData);
    }

    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // Get Post object and use the values to update the UI

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            // ...
        }
    };

}
