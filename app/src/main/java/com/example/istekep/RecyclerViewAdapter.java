package com.example.istekep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<View_Holder>
{
    public List<RecyclerViewData> list;
    private Context context;
    public RecyclerViewAdapter(){
        list=new ArrayList<>();
    }

    public RecyclerViewAdapter(Context context,List<RecyclerViewData> list)
    {
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout,parent,false);
        View_Holder holder =new View_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        holder.title.setText(list.get(position).title);
        holder.desc.setText(list.get(position).desc);
        holder.image.setImageResource(list.get(position).image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
