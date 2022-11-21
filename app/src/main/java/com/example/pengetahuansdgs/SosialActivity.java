package com.example.pengetahuansdgs;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class SosialActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private SosialAdapter adapter;
    ListView listView;
    private ArrayList<Sosial> sosials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosial);
        adapter = new SosialAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

//

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id){

                    Toast.makeText(SosialActivity.this,
                            sosials.get(i).getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

        private void prepare() {
            dataName = getResources().getStringArray(R.array.data_name);
            dataDescription = getResources().getStringArray(R.array.data_description);
            dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        }

        private void addItem() {
            sosials = new ArrayList<>();

            for (int i = 0; i < dataName.length; i++) {
                Sosial sosial = new Sosial();
                sosial.setPhoto(dataPhoto.getResourceId(i, -1));
                sosial.setName(dataName[i]);
                sosial.setDescription(dataDescription[i]);
                sosials.add(sosial);
            }
            adapter.setSosials(sosials);
        }

}
