package com.example.pengetahuansdgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LingkunganActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private LingkunganAdapter adapter;
    ListView listView;
    private ArrayList<Lingkungan> lingkungans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkungan);
        adapter = new LingkunganAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id){

                    Toast.makeText(LingkunganActivity.this,
                            lingkungans.get(i).getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name3);
        dataDescription = getResources().getStringArray(R.array.data_description3);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo3);

    }

    private void addItem() {
        lingkungans = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Lingkungan lingkungan = new Lingkungan();
            lingkungan.setPhoto(dataPhoto.getResourceId(i, -1));
            lingkungan.setName(dataName[i]);
            lingkungan.setDescription(dataDescription[i]);
            lingkungans.add(lingkungan);
        }
        adapter.setLingkungans(lingkungans);
    }
}