package com.example.pengetahuansdgs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KelolaAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<Kelola> kelolas;



    public void setKelolas(ArrayList<Kelola> kelolas) {
        this.kelolas = kelolas;
    }

    public KelolaAdapter(Context context) {
        this.context = context;
        kelolas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return kelolas.size();
    }

    @Override
    public Object getItem(int i) {
        return kelolas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_kelola, viewGroup, false);

        }

        ViewHolder viewHolder = new ViewHolder(view);
        Kelola kelola = (Kelola) getItem(i);
        viewHolder.bind(kelola);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name4);
            txtDescription = view.findViewById(R.id.txt_description4);
            imgPhoto = view.findViewById(R.id.img_photo4);
        }

        void bind(Kelola kelola) {
            txtName.setText(kelola.getName());
            txtDescription.setText(kelola.getDescription());
            imgPhoto.setImageResource(kelola.getPhoto());
        }
    }
}