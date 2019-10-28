package com.example.comicbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterComic extends RecyclerView.Adapter<HolderComic> {

    Context c;
    ArrayList<ModelComic> modelComicArrayList;


    public AdapterComic(Context c,ArrayList<ModelComic> modelComic){
        this.c = c;
        this.modelComicArrayList = modelComic;
    }

    @NonNull
    @Override
    public HolderComic onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_comic,null);
        return new HolderComic(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderComic holder, int position) {
        holder.ivCover.setBackgroundResource(modelComicArrayList.get(position).getImageComic());
        holder.tvTitle.setText(modelComicArrayList.get(position).getTitleComic());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                //data yang akan di passing disimpan pada masing-masing variabel

                int intCover = modelComicArrayList.get(pos).getImageComic();
                int intFullComic = modelComicArrayList.get(pos).getImageFullComic();
                String strTitle = modelComicArrayList.get(pos).getTitleComic();


                //bundel data yang akan di passing ke activity detail
                //parameter key dan variabel
                Bundle bndlComic = new Bundle();
                bndlComic.putInt("bndlCover", intCover);
                bndlComic.putInt("bndlFullComic", intFullComic);
                bndlComic.putString("bndlTitle", strTitle);

                //mulai intent
                //c adalah konteks, karena Adapter Mahasiswa bukan Activity harus-
                //mengunakan context
                Intent intentRead = new Intent(c, ReadActivity.class);
                intentRead.putExtras(bndlComic);
                c.startActivity(intentRead);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelComicArrayList.size();
    }
}