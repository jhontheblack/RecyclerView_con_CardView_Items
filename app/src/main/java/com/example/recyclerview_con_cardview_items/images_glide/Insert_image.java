package com.example.recyclerview_con_cardview_items.images_glide;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;

public class Insert_image {

    private ImageView img;
    private String url_image;
    private Context context;

    public Insert_image(ImageView img, Context context, String url_image){
        this.img=img;
        this.url_image=url_image;
        this.context=context;
        insert();
    }

    //getters y setters
    private void insert()
    {
        Glide.with(getContext()).load(getUrl_image()).into(getImg());
        Log.i(Messages_parameters.mensaje_key,"Imagen añadida correctamente");
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
