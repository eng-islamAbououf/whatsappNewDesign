package com.example.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    ArrayList <UserMoudel> data = new ArrayList<>();
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
        view = inflater.inflate(R.layout.fragment_chat,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data.clear();
        addFakeData();
        listView=view.findViewById(R.id.list_chat);
        adapter=new MyAdapter(getContext(),R.layout.chat_item,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void addFakeData(){
        for (int i =1 ;i<=15;i++)
            data.add(new UserMoudel(R.drawable.logo,"user "+i));
    }
}