package com.example.istekep;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;
        recyclerView=findViewById(R.id.recyclerView);

//        list.add(new RecyclerViewData("ISTE","ISTE NITK",R.drawable.iste));
//        list.add(new RecyclerViewData("Baby Yoda","Yoda but a baby",R.drawable.babyyoda));
//        list.add(new RecyclerViewData("Thug Life","Don't ask why",R.drawable.thuglife));

        final List<Integer> image_list = new ArrayList<Integer>();
        image_list.add(R.drawable.iste);
        image_list.add(R.drawable.babyyoda);
        image_list.add(R.drawable.thuglife);



        adapter = new RecyclerViewAdapter();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if(dataSnapshot.exists()){
                    RecyclerViewData data =dataSnapshot.getValue(RecyclerViewData.class);
                    data.image =image_list.get(data.image);
                    adapter.list.add(data);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
