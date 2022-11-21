package com.example.pengetahuansdgs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LingkunganAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<Lingkungan> lingkungans;



    public void setLingkungans(ArrayList<Lingkungan> lingkungans) {
        this.lingkungans = lingkungans;
    }

    public LingkunganAdapter(Context context) {
        this.context = context;
        lingkungans = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return lingkungans.size();
    }

    @Override
    public Object getItem(int i) {
        return lingkungans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lingkungan, viewGroup, false);

        }

        ViewHolder viewHolder = new ViewHolder(view);
        Lingkungan lingkungan = (Lingkungan) getItem(i);
        viewHolder.bind(lingkungan);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name3);
            txtDescription = view.findViewById(R.id.txt_description3);
            imgPhoto = view.findViewById(R.id.img_photo3);
        }

        void bind(Lingkungan lingkungan) {
            txtName.setText(lingkungan.getName());
            txtDescription.setText(lingkungan.getDescription());
            imgPhoto.setImageResource(lingkungan.getPhoto());
        }
    }
}