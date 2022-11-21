package com.example.pengetahuansdgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KelolaActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private KelolaAdapter adapter;
    ListView listView;
    private ArrayList<Kelola> kelolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola);
        adapter = new KelolaAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id){

                    Toast.makeText(KelolaActivity.this,
                            kelolas.get(i).getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name4);
        dataDescription = getResources().getStringArray(R.array.data_description4);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo4);

    }

    private void addItem() {
        kelolas = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Kelola kelola = new Kelola();
            kelola.setPhoto(dataPhoto.getResourceId(i, -1));
            kelola.setName(dataName[i]);
            kelola.setDescription(dataDescription[i]);
            kelolas.add(kelola);
        }
        adapter.setKelolas(kelolas);
    }
}