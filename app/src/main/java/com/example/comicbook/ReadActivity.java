package com.example.comicbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ActionMenuView;
import android.widget.ImageView;

public class ReadActivity extends AppCompatActivity {

    ImageView ivFullComic;
    Toolbar toolbarRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ivFullComic = findViewById(R.id.image_full_comic);
        toolbarRead = findViewById(R.id.toolbar_read);

        setSupportActionBar(toolbarRead);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

            Bundle bndlComic = getIntent().getExtras();
            ivFullComic.setImageResource(bndlComic.getInt("bndlFullComic"));
            String strTitle = bndlComic.getString("bndlTitle");
            getSupportActionBar().setTitle(strTitle);
    }
}