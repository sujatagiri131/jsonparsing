package com.android.jsontraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jsontraining.model.Model;
import com.bumptech.glide.Glide;

import java.util.List;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder> {

    Context context;
    List<Model>models;

    public Recyclerviewadapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public Recyclerviewadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Recyclerviewadapter.ViewHolder holder, int position) {
        final Model model=models.get(position);
        holder.textname.setText(model.getItem_Name());
        holder.textprice.setText(model.getItem_Price());
        holder.textdesc.setText(model.getItem_Desc());
        //loading image in imageview
        Glide.with(context).load("http://vedisapp.berlin-webdesign-agentur.de/Image/"+model.getImage())
               .placeholder(R.mipmap.ic_launcher)
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Draw.class);
                intent.putExtra("name",model.getItem_Name());
                intent.putExtra("itemprice",model.getItem_Price());
                context.startActivity(intent);
            //  context.startActivity(new Intent(context,Draw.class));
            }
        });

    }
    @Override
    public int getItemCount() {

        return models.size();


    }

    class ViewHolder extends RecyclerView.ViewHolder{

            TextView textname,textdesc,textprice;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image =(ImageView)itemView.findViewById(R.id.image);
            textname= (TextView) itemView.findViewById(R.id.name);
            textdesc= (TextView) itemView.findViewById(R.id.item_dec);
            textprice=(TextView) itemView.findViewById(R.id.item_price);
        }
    }
}