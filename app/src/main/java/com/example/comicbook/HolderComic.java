package com.example.comicbook;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderComic extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView ivCover;
    TextView tvTitle;

    //interface ItemClickListener
    ItemClickListener itemClickListener;

    public HolderComic(@NonNull View itemView){
        super(itemView);

        this.ivCover = itemView.findViewById(R.id.image_cover);
        this.tvTitle = itemView.findViewById(R.id.text_title);

        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}
