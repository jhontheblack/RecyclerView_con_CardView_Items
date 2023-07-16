package com.example.recyclerview_con_cardview_items.recycler_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_con_cardview_items.R;
import com.example.recyclerview_con_cardview_items.model.Products;

import java.util.List;

public class Products_adapter extends RecyclerView.Adapter<Products_view_holder>{

    private List<Products> lst_products;

    public Products_adapter(List<Products> lst_products)
    {
        this.lst_products=lst_products;
    }


    @NonNull
    @Override
    public Products_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        return new Products_view_holder(layoutInflater.inflate(R.layout.items_data,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Products_view_holder holder, int position) {
        holder.view_holder(lst_products.get(position));
    }

    @Override
    public int getItemCount() {
        return lst_products.size();
    }
}
