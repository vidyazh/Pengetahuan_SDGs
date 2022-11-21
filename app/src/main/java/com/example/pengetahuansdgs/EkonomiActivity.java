package com.example.pengetahuansdgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class EkonomiActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private EkonomiAdapter adapter;
    ListView listView;
    private ArrayList<Ekonomi> ekonomis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekonomi);
        adapter = new EkonomiAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id){

                    Toast.makeText(EkonomiActivity.this,
                            ekonomis.get(i).getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name2);
        dataDescription = getResources().getStringArray(R.array.data_description2);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo2);

    }

    private void addItem() {
        ekonomis = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Ekonomi ekonomi = new Ekonomi();
            ekonomi.setPhoto(dataPhoto.getResourceId(i, -1));
            ekonomi.setName(dataName[i]);
            ekonomi.setDescription(dataDescription[i]);
            ekonomis.add(ekonomi);
        }
        adapter.setEkonomis(ekonomis);
    }

}
