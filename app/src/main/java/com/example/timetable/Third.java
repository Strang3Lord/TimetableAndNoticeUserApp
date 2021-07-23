package com.example.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Third extends AppCompatActivity {
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        final Intent intent = new Intent(getApplicationContext(), pdf_reader.class);

        findViewById(R.id.te1).setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     string = "TE COMP 1";
                     intent.putExtra("dept", string);
                     startActivity(intent);
                 }
             });
               findViewById(R.id.te2).setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     string = "TE COMP 2";
                     intent.putExtra("dept", string);
                     startActivity(intent);
                 }});
        findViewById(R.id.tess).setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     string = "TE COMP SS";
                     intent.putExtra("dept", string);
                     startActivity(intent);
                 }
             });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent categoryIntent = new Intent(Third.this,MainActivity.class);
             startActivity(categoryIntent);
             finish();
         }
     });
        ImageSlider imageslider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.compdept));
        slideModels.add(new SlideModel(R.drawable.im3));
        slideModels.add(new SlideModel(R.drawable.clg3));
        imageslider.setImageList(slideModels,true);

    }
}
