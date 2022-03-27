package com.example.verbumquest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class Credits extends Activity {


    CardView creditsJoël;
    TextView linkedinJoël;

    CardView creditsAdri;
    TextView linkedinAdri;

    CardView creditsAlbert;
    TextView linkedinAlbert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(Credits.this.getAssets(), ubicacio);

        CardView creditsJoël = findViewById(R.id.joelmarpons);
        //TextView linkedinJoël = findViewById(R.id.linkedinJoël);

        CardView creditsAdri = findViewById(R.id.adriacastany);
        //TextView linkedinAdri = findViewById(R.id.linkedinAdri);

        CardView creditsAlbert = findViewById(R.id.albertmora);
        //TextView linkedinAlbert = findViewById(R.id.linkedinAlbert);

        linkedinJoël.setTypeface(Tf);
        linkedinAdri.setTypeface(Tf);
        linkedinAlbert.setTypeface(Tf);

        linkedinJoël.setOnClickListener(new  View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String url = "https://www.linkedin.com/in/jo%C3%ABl-marpons-gonzalez-767629225/";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

        linkedinAdri.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = "https://www.linkedin.com/in/adri%C3%A0-castany-aaaaaa1b7/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        linkedinAlbert.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = "https://www.linkedin.com/in/albert-mora-costillo-219301226/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}
