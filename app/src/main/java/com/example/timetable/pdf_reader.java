package com.example.timetable;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class pdf_reader extends AppCompatActivity {

    private String value;
    private PDFView pdfView;



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_reader);

        final String dept = getIntent().getStringExtra("dept");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        assert dept != null;
        DatabaseReference reference = database.getReference(dept);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Opening...");
        progressDialog.show();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    value = snapshot.getValue(String.class);
                    new RetrievePDFStream().execute(value);
                } else if(!snapshot.exists()) {
                    progressDialog.dismiss();
                    Toast.makeText(pdf_reader.this, "Not updated by faculty yet", Toast.LENGTH_SHORT).show();
//                    if(dept.equals("SE COMP 1") || dept.equals("SE COMP 2") || dept.equals("SE COMP SS")){
//                        startActivity(new Intent(getApplicationContext(),Second.class));
//                    }else if(dept.equals("TE COMP 1") || dept.equals("TE COMP 2") || dept.equals("TE COMP SS")){
//                        startActivity(new Intent(getApplicationContext(),Third.class));
//                    }else if(dept.equals("BE COMP 1") || dept.equals("BE COMP 2") || dept.equals("BE COMP SS")){
//                        startActivity(new Intent(getApplicationContext(),Fourth.class));
//                    }
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss();
                Toast.makeText(pdf_reader.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
            @SuppressLint("StaticFieldLeak")
            class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {
                @Override
                protected InputStream doInBackground(String... strings) {
                    InputStream inputStream = null;
                    try {
                        URL uri = new URL(strings[0]);
                        HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
                        if (urlConnection.getResponseCode() == 200) {
                            inputStream = new BufferedInputStream(urlConnection.getInputStream());
                        }
                    } catch (IOException e) {
                        return null;
                    }
                    return inputStream;
                }
                @Override
                protected void onPostExecute(InputStream inputStream) {
                    super.onPostExecute(inputStream);
                    pdfView.fromStream(inputStream).load();
                    progressDialog.dismiss();
                }
            }
        });
    }
}
