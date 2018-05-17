package com.example.ahmed.autocompletetextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView auto_country;
    MultiAutoCompleteTextView MultiAuto_job;
    EditText edit_name;
    Button btn_show;
    String arr_country[], arr_jobs[];
    String name, country, job;
    ArrayAdapter<String> adapter_country, adapter_jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = (EditText) findViewById(R.id.edit_name);
        btn_show = (Button) findViewById(R.id.btn_show);
        auto_country = (AutoCompleteTextView) findViewById(R.id.txt_country);
        MultiAuto_job = (MultiAutoCompleteTextView) findViewById(R.id.txt_job);

        arr_country = getResources().getStringArray(R.array.arr_country);
        arr_jobs = getResources().getStringArray(R.array.arr_job);

        adapter_country = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arr_country);
        adapter_jobs = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arr_jobs);

        auto_country.setAdapter(adapter_country);
        MultiAuto_job.setAdapter(adapter_jobs);
        MultiAuto_job.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        auto_country.setThreshold(1);
        MultiAuto_job.setThreshold(1);

        auto_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                country = "" + adapterView.getItemAtPosition(i);
            }
        });


        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edit_name.getText().toString();
                job = MultiAuto_job.getText().toString();

                Intent intent = new Intent(MainActivity.this, ShowInfo.class);
                intent.putExtra("name", name);
                intent.putExtra("country", country);
                intent.putExtra("job", job);
                startActivity(intent);
            }
        });
    }
}
