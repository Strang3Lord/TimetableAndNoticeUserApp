package com.example.timetable.NoticeFeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.timetable.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class NoticeFeed extends AppCompatActivity {

    private RecyclerView feedRecycler;
    private Context context;
    private List<uploadPDF> list;
    private PdfAdapter adapter ;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_feed);

        feedRecycler = findViewById(R.id.feedRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    uploadPDF data = snapshot.getValue(uploadPDF.class);
                    list.add(data);
                }
                adapter = new PdfAdapter(NoticeFeed.this, list);
                feedRecycler.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NoticeFeed.this);
                linearLayoutManager.setReverseLayout(true);
                linearLayoutManager.setStackFromEnd(true);
                feedRecycler.setLayoutManager(linearLayoutManager);
                feedRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                makeText(getApplicationContext(), databaseError.getMessage(), LENGTH_SHORT).show();
            }
        });

    }
}