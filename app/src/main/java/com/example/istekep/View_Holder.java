package com.example.istekep;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class View_Holder extends RecyclerView.ViewHolder
{
    public TextView title;
    public TextView desc;
    public ImageView image;
    public View_Holder(@NonNull View itemView) {
        super(itemView);
        title = (TextView)itemView.findViewById(R.id.title_textview);
        desc = (TextView)itemView.findViewById(R.id.desc_textview);
        image = (ImageView)itemView.findViewById(R.id.image_view);

    }
}
