package com.example.recyclerview_con_cardview_items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;
import com.example.recyclerview_con_cardview_items.model.Products;
import com.example.recyclerview_con_cardview_items.recycler_view.Images_product_adapter;

public class Activity_images_resul extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView txt_title;

    private Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_resul);
        //
        get_result();
        init_controls();
        set_adapter();
    }


    private void get_result()
    {
        Bundle b=this.getIntent().getExtras();
        products=(Products) b.getSerializable(Messages_parameters.key_object);
    }

    private void init_controls()
    {
        recyclerView=findViewById(R.id.rv_items_r);
        //con el GridLayoutManager primero recibe el contexto y como segundo parametro la cantidad de columnas
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //
        txt_title=findViewById(R.id.txt_title_item);
    }


    private void set_adapter()
    {
        txt_title.setText(products.getTitle());
        //
        Images_product_adapter images_product_adapter=new Images_product_adapter(products.getImages());
        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setAdapter(images_product_adapter);
    }

}