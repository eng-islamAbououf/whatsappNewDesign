package com.example.whatsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class StatusFragment extends Fragment {
ArrayList <UserMoudel> data = new ArrayList<> ();
ListView listView;
Context context ;
View view;
MyAdapter adapter;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_status,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFakeData();
        listView=view.findViewById(R.id.list_status);
        adapter =new MyAdapter(getContext(),R.layout.status_item,data);
        listView.setAdapter(adapter);

    }

    protected void addFakeData (){
        for (int i = 1 ; i <= 10 ; i++)
            data.add(new UserMoudel(R.drawable.ic_launcher_background,"User "+i));
    }
}