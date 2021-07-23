package com.example.timetable;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        ImageSlider imageslider = findViewById(R.id.slider1);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.compdept));
        slideModels.add(new SlideModel(R.drawable.im3));
        slideModels.add(new SlideModel(R.drawable.clg3));
        imageslider.setImageList(slideModels,true);

        final Intent intent = new Intent(getApplicationContext(), pdf_reader.class);

        findViewById(R.id.se1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "SE COMP 1";
                intent.putExtra("dept", string);
                startActivity(intent);
            }
        });
        findViewById(R.id.se2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "SE COMP 2";
                intent.putExtra("dept", string);
                startActivity(intent);
            }});
        findViewById(R.id.sess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "SE COMP SS";
                intent.putExtra("dept", string);
                startActivity(intent);
            }});

        findViewById(R.id.backse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(Second.this, MainActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });
    }
}
