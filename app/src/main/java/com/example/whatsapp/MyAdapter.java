package com.example.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter {

    private ArrayList <UserMoudel> data ;

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserMoudel>data) {
        super(context, resource, data);
        this.data= data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.general_item, parent, false);
        ImageView image = convertView.findViewById(R.id.general_image);
        TextView text = convertView.findViewById(R.id.general_title);
        image.setImageResource(data.get(position).getImage());
        text.setText(data.get(position).title);
        return convertView;

    }
}
