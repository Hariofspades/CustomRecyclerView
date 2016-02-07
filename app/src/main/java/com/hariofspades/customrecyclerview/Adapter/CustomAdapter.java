package com.hariofspades.customrecyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.hariofspades.customrecyclerview.Pojo.CustomPojo;
import com.hariofspades.customrecyclerview.R;

import java.util.ArrayList;

/** Authuor: Hari vignesh Jayapalan
 *  Created on: 6 Feb 2016
 *  Email: hariutd@gmail.com
 *
 *  Implementing custom RecyclerView Adapter
 *  Tutorial @ https://medium.com/@harivigneshjayapalan
 * */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    //Creating an arraylist of POJO objects
    private ArrayList<CustomPojo> list_members=new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;


    public CustomAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }


    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.custom_row, parent, false);
        holder=new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CustomPojo list_items=list_members.get(position);
        holder.user_name.setText(list_items.getName());
        holder.content.setText(list_items.getContent());
        holder.time.setText(list_items.getTime());
    }

    //Setting the arraylist
    public void setListContent(ArrayList<CustomPojo> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());

    }


    @Override
    public int getItemCount() {
        return list_members.size();
    }


    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView user_name,content,time;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            content=(TextView)itemView.findViewById(R.id.content);
            time=(TextView)itemView.findViewById(R.id.time);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }

}
