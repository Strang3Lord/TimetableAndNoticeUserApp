package com.example.timetable;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        findViewById(R.id.gmp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"piyushmanwar74@gmail.com"});
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.gms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"svshingare67@gmail.com"});
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        findViewById(R.id.gmr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"deshpande.ranjeet8@gmail.com"});
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        findViewById(R.id.gmh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "harshaldeokar56@gmail.com"});
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.gits).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.github.com");
            }
        });findViewById(R.id.gith).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.github.com/HarshalDeokar99");
            }
        });findViewById(R.id.gitr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.github.com/RunJeetDeshpande");
            }
        });findViewById(R.id.gitp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("https://github.com/Strang3Lord");
            }
        });findViewById(R.id.instap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.instagram.com/piyush.manwar/");
            }
        });findViewById(R.id.instah).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.instagram.com/harshaldeokar_/");
            }
        });findViewById(R.id.instar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.instagram.com/runjeet/");
            }
        });findViewById(R.id.instas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbrowser("http://www.instagram.com/shubham_shingare_20");
            }
        });
    }

    private void openbrowser(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}