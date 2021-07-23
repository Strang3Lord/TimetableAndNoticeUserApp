package com.example.timetable;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Fourth extends AppCompatActivity {
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);

        ImageSlider imageslider = findViewById(R.id.slider2);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.compdept));
        slideModels.add(new SlideModel(R.drawable.im3));
        slideModels.add(new SlideModel(R.drawable.clg3));
        imageslider.setImageList(slideModels,true);

        Button backbe;
        backbe = findViewById(R.id.backbe);
        backbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(Fourth.this,MainActivity.class);
                startActivity(categoryIntent);
                finish();
            }
        });

        final Intent intent = new Intent(getApplicationContext(), pdf_reader.class);

        findViewById(R.id.be1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "BE COMP 1";
                intent.putExtra("dept", string);
                startActivity(intent);
            }
        });
        findViewById(R.id.be2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "BE COMP 2";
                intent.putExtra("dept", string);
                startActivity(intent);
            }});
        findViewById(R.id.bess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = "BE COMP SS";
                intent.putExtra("dept", string);
                startActivity(intent);
            }});

    }
}
