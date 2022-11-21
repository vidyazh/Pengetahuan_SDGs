package com.example.pengetahuansdgs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class EkonomiAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Ekonomi> ekonomis;

    public void setEkonomis(ArrayList<Ekonomi> ekonomis) {
        this.ekonomis = ekonomis;
    }

    public EkonomiAdapter(Context context) {
        this.context = context;
        ekonomis = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return ekonomis.size();
    }

    @Override
    public Object getItem(int i) {
        return ekonomis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_ekonomi, viewGroup, false);

        }

        EkonomiAdapter.ViewHolder viewHolder = new EkonomiAdapter.ViewHolder(view);
        Ekonomi ekonomi = (Ekonomi) getItem(i);
        viewHolder.bind(ekonomi);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name2);
            txtDescription = view.findViewById(R.id.txt_description2);
            imgPhoto = view.findViewById(R.id.img_photo2);
        }

        void bind(Ekonomi ekonomi) {
            txtName.setText(ekonomi.getName());
            txtDescription.setText(ekonomi.getDescription());
            imgPhoto.setImageResource(ekonomi.getPhoto());
        }
    }
}
