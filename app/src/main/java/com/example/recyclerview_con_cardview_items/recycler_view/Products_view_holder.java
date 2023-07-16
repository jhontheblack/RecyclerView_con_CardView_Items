package com.example.recyclerview_con_cardview_items.recycler_view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_con_cardview_items.Activity_images_resul;
import com.example.recyclerview_con_cardview_items.R;
import com.example.recyclerview_con_cardview_items.images_glide.Insert_image;
import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;
import com.example.recyclerview_con_cardview_items.model.Products;

import java.util.function.Function;

public class Products_view_holder extends RecyclerView.ViewHolder{


    private View view;
    private TextView title;
    private TextView description;
    private TextView price;
    private TextView discountPercentage;
    private TextView rating;
    private TextView stock;
    private TextView brand;
    private TextView category;
    private ImageView images;

    public Products_view_holder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
        init_controls();
    }


    public void view_holder(Products products)
    {
        title.setText(products.getTitle());
        description.setText(products.getDescription());
        price.setText(products.getPrice());
        discountPercentage.setText(products.getDiscount_percentage()+" %");
        rating.setText(products.getRating());
        stock.setText(products.getStock());
        brand.setText(products.getBrand());
        category.setText(products.getCategory());
        new Insert_image(images,view.getContext(),products.getThumbnail());

        view.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(Messages_parameters.mensaje_key,"Ha presionado sobre el producto");
                Intent intent=new Intent(view.getContext(), Activity_images_resul.class);
                Bundle b=new Bundle();
                b.putSerializable(Messages_parameters.key_object,products);
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
    }


    private void init_controls()
    {
        title=view.findViewById(R.id.lbl_title);
        description=view.findViewById(R.id.lbl_description);
        price=view.findViewById(R.id.lbl_price);
        discountPercentage=view.findViewById(R.id.lbl_discount_percentage);
        rating=view.findViewById(R.id.lbl_rating);
        stock=view.findViewById(R.id.lbl_stock);
        brand=view.findViewById(R.id.lbl_brand);
        category=view.findViewById(R.id.lbl_category);
        images=view.findViewById(R.id.img_thumbnail);
    }


    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
