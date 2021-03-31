package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
ImageButton camera;
  ViewPager viewPager;
  MyFragmentAdabter myFragmentAdabter;
  TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intiView();

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Toast.makeText(HomeActivity.this,""+tab.getText(),Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if (item.getItemId()==R.id.New_group)
                Toast.makeText(HomeActivity.this,"New group" ,Toast.LENGTH_SHORT).show();
            else if (item.getItemId()==R.id.New_broadcast)
                Toast.makeText(HomeActivity.this,"New Broadcast" ,Toast.LENGTH_SHORT).show();
            else if (item.getItemId()==R.id.web)
                Toast.makeText(HomeActivity.this,"WhatsApp Web" ,Toast.LENGTH_SHORT).show();
            else if (item.getItemId()==R.id.starred)
                Toast.makeText(HomeActivity.this,"Starred Message" ,Toast.LENGTH_SHORT).show();
            else if (item.getItemId()==R.id.sittings)
                Toast.makeText(HomeActivity.this,"Sittings" ,Toast.LENGTH_SHORT).show();
            else if (item.getItemId()==R.id.search)
                Toast.makeText(HomeActivity.this,"Search" ,Toast.LENGTH_SHORT).show();
            return true;

    }

    private void intiView(){
        camera=findViewById(R.id.btn);
        viewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayout);
        myFragmentAdabter=new MyFragmentAdabter(getSupportFragmentManager(),1,tabLayout.getTabCount());
        viewPager.setAdapter(myFragmentAdabter);
    }

    public void go(View view) {
        startActivity(new Intent(this,Test.class));
    }
}