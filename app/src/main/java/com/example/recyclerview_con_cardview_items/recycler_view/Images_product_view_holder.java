package com.example.recyclerview_con_cardview_items.recycler_view;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_con_cardview_items.R;
import com.example.recyclerview_con_cardview_items.images_glide.Insert_image;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Images_product_view_holder extends RecyclerView.ViewHolder {

    private ImageView img_product;

    public Images_product_view_holder(@NonNull View itemView) {
        super(itemView);
        init_controls();
    }


    public void view_holder(String url_image)
    {
        new Insert_image(img_product, itemView.getContext(),url_image);
        init_dialog(url_image);
    }


    private void init_controls()
    {
        img_product= itemView.findViewById(R.id.img_item_resul);
    }


    private void init_dialog(String url)
    {
        Dialog dialog=new Dialog(itemView.getContext());
        dialog.setContentView(R.layout.dialog_image);
        ImageView img_dialog=dialog.findViewById(R.id.img_dialog);
        FloatingActionButton btn_cerrar_dialog=dialog.findViewById(R.id.btn_close_dialog);
        //btn_cerrar_dialog.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.ic_cancel));
        btn_cerrar_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Insert_image(img_dialog, itemView.getContext(),url);
                dialog.show();
            }
        });
    }


}
