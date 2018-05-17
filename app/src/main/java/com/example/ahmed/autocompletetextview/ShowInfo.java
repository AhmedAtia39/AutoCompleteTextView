package com.example.ahmed.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        TextView textView = (TextView) findViewById(R.id.txt_info);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String country = bundle.getString("country");
        String job = bundle.getString("job");

        textView.setText("-Name:\n" + name + "\n\n-Country:\n" + country + "\n\n-Job:\n" + job);
    }
}
