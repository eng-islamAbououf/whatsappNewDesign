package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    ImageButton mic ,emoji , attachment ,camera ;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intiView();
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatActivity.this,"Recording " ,Toast.LENGTH_SHORT).show();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatActivity.this,"Opening a Camera " ,Toast.LENGTH_SHORT).show();
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatActivity.this,"Insert Media " ,Toast.LENGTH_SHORT).show();
            }
        });

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatActivity.this,"Open emoji " ,Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.viewContent)
            Toast.makeText(ChatActivity.this,"View content" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Media)
            Toast.makeText(ChatActivity.this,"Media, links, and docs" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Search)
            Toast.makeText(ChatActivity.this,"Search" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Wallpaper)
            Toast.makeText(ChatActivity.this,"Wallpaper" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Mute)
            Toast.makeText(ChatActivity.this,"Mute notifications" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Report)
            Toast.makeText(ChatActivity.this,"Report" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Block)
            Toast.makeText(ChatActivity.this,"Block" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Clear)
            Toast.makeText(ChatActivity.this,"Clear Chat" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Export)
            Toast.makeText(ChatActivity.this,"Export Chat" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.Add)
            Toast.makeText(ChatActivity.this,"Add shortcut" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.call)
            Toast.makeText(ChatActivity.this,"Voice Call" ,Toast.LENGTH_SHORT).show();
        else if (item.getItemId()==R.id.vcall)
            Toast.makeText(ChatActivity.this,"Video Call" ,Toast.LENGTH_SHORT).show();
        return true;
    }

    private void intiView(){
        mic = findViewById(R.id.mic);
        emoji = findViewById(R.id.emoji);
        attachment = findViewById(R.id.camera2);
        camera = findViewById(R.id.camera);
        text= findViewById(R.id.text5);
    }
}