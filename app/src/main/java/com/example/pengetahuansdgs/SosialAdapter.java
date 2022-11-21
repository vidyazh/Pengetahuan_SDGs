package com.example.pengetahuansdgs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;




public class SosialAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<Sosial> sosials;



    public void setSosials(ArrayList<Sosial> sosials) {
        this.sosials = sosials;
    }

    public SosialAdapter(Context context) {
        this.context = context;
        sosials = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return sosials.size();
    }

    @Override
    public Object getItem(int i) {
        return sosials.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_sosial, viewGroup, false);

        }

        ViewHolder viewHolder = new ViewHolder(view);
        Sosial sosial = (Sosial) getItem(i);
        viewHolder.bind(sosial);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Sosial sosial) {
            txtName.setText(sosial.getName());
            txtDescription.setText(sosial.getDescription());
            imgPhoto.setImageResource(sosial.getPhoto());
        }
    }
}

