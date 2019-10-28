package com.example.comicbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    Toolbar toolbar;

    AdapterComic adapterComic;
    RecyclerView recyclerViewComic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.activity_main);
        toolbar = findViewById(R.id.toolbar);

        recyclerViewComic = findViewById(R.id.recycler_list);

        recyclerViewComic.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewComic.setLayoutManager(new GridLayoutManager(this,2));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerViewComic.addItemDecoration(itemDecoration);

        adapterComic = new AdapterComic(this, getComic());
        recyclerViewComic.setAdapter(adapterComic);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

        navigationView =  findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.tentang:
                        Toast.makeText(MainActivity.this, "Menu 1",Toast.LENGTH_SHORT).show();break;
                    case R.id.keluar:
                        finish();
                    default:
                        return true;
                }
                return true;
            }
        });

    }

    private ArrayList<ModelComic> getComic() {

        ArrayList<ModelComic> modelComicArrayList = new ArrayList<>();

        ModelComic modelComic = new ModelComic();

        modelComic.setImageComic(R.drawable.aku_suka_buah_cover);
        modelComic.setImageFullComic(R.drawable.aku_suka_buah_full);
        modelComic.setTitleComic("Aku Suka Buah");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.anak_berbudi_pekerti_cover);
        modelComic.setImageFullComic(R.drawable.anak_berbudi_pekerti_full);
        modelComic.setTitleComic("Anak Berbudi Pekerti");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.anak_jujur_yang_hebat_cover);
        modelComic.setImageFullComic(R.drawable.anak_jujur_yang_hebat_full);
        modelComic.setTitleComic("Anak Jujur Yang hebat");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.asyiknya_berbagi_cover);
        modelComic.setImageFullComic(R.drawable.asyiknya_berbagi_full);
        modelComic.setTitleComic("Asyiknya Berbagi");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.ayo_beramal_cover);
        modelComic.setImageFullComic(R.drawable.ayo_beramal_full);
        modelComic.setTitleComic("Ayo Beramal");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.kucing_emas_cover);
        modelComic.setImageFullComic(R.drawable.kucing_emas_full);
        modelComic.setTitleComic("Kucing Emas");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.sarjana_kecil_cover);
        modelComic.setImageFullComic(R.drawable.sarjana_kecil_full);
        modelComic.setTitleComic("Sarjana Kecil");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.sehat_kuat_pintar_cover);
        modelComic.setImageFullComic(R.drawable.sehat_kuat_pintar_full);
        modelComic.setTitleComic("Sehat Kuat Pintar");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.siapa_paling_cantik_cover);
        modelComic.setImageFullComic(R.drawable.siapa_paling_cantik_full);
        modelComic.setTitleComic("Siapa Paling Cantik");
        modelComicArrayList.add(modelComic);

        modelComic = new ModelComic();
        modelComic.setImageComic(R.drawable.tupai_cover);
        modelComic.setImageFullComic(R.drawable.tupai_full);
        modelComic.setTitleComic("Tupai");
        modelComicArrayList.add(modelComic);

        return modelComicArrayList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}