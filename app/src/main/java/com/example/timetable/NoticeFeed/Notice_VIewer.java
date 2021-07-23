package com.example.timetable.NoticeFeed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.timetable.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Notice_VIewer extends AppCompatActivity {

    private PDFView pdfView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_viewer);

//        FirebaseDatabase database= FirebaseDatabase.getInstance();
//        DatabaseReference reference = database.getReference("pdf");
        pdfView = (PDFView) findViewById(R.id.pdfView);

        url = getIntent().getStringExtra("uri");
//        pdfView.fromUri(Uri.parse(url));
        new RetrievePDFStream().execute(url);
        Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show();
        
    }

    @SuppressLint("StaticFieldLeak")
    private class RetrievePDFStream extends AsyncTask<String, Void, InputStream>  {
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
                Toast.makeText(Notice_VIewer.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute(inputStream);
            pdfView.fromStream(inputStream).load();
        }
    }
}
