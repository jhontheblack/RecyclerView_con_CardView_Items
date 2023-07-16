package com.example.recyclerview_con_cardview_items.recycler_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_con_cardview_items.R;
import com.example.recyclerview_con_cardview_items.model.Products;

import java.util.List;

public class Images_product_adapter extends RecyclerView.Adapter<Images_product_view_holder> {

    private List<String> lst_urls_images;

    public Images_product_adapter(List<String> lst_urls_images)
    {
        this.lst_urls_images=lst_urls_images;
    }

    @NonNull
    @Override
    public Images_product_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        return new Images_product_view_holder(layoutInflater.inflate(R.layout.item_product_resul,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Images_product_view_holder holder, int position) {
        holder.view_holder(lst_urls_images.get(position));
    }

    @Override
    public int getItemCount() {
        return getLst_urls_images().size();
    }


    //getter y setter
    public List<String> getLst_urls_images() {
        return lst_urls_images;
    }

    public void setLst_urls_images(List<String> lst_urls_images) {
        this.lst_urls_images = lst_urls_images;
    }
}
