package com.example.crypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.ViewHolder> {

    private ArrayList<ParseItem> parseItems;
    private Context context;

    public ParseAdapter(ArrayList<ParseItem> parseItems,Context context) {
        this.parseItems = parseItems;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parse_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParseItem parseItem= parseItems.get(position);
        holder.name.setText(parseItem.getNameofcurrency());
        holder.value.setText(parseItem.getValue());
        Picasso.get().load(new ParseItem().getImageurl(holder.icon));
    }

    @Override
    public int getItemCount() {
        return parseItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView name;
        TextView value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon =icon.findViewById(R.id.cryptoicon);
            name=name.findViewById(R.id.name);
            value= value.findViewById(R.id.capita);
        }
    }
}
