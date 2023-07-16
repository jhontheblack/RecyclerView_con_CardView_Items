package com.example.recyclerview_con_cardview_items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.recyclerview_con_cardview_items.deserialize.Deserialize_response;
import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;
import com.example.recyclerview_con_cardview_items.recycler_view.Products_adapter;
import com.example.recyclerview_con_cardview_items.volley_request.Request_volley;

public class MainActivity extends AppCompatActivity {

    private Request_volley request_volley;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_controls();
        Thread_response();
    }


    private void init_controls()
    {
        recyclerView=findViewById(R.id.rv_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void Thread_response()
    {
        request_volley=new Request_volley(MainActivity.this);
        Thread thread_response=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (request_volley.getResponse() == Messages_parameters.status_empty) {
                        Log.i(Messages_parameters.mensaje_key, "Getting data from " + Messages_parameters.url);
                        Thread.sleep(500);
                    }
                    if(request_volley.getResponse()!=Messages_parameters.response_error)
                    {
                        Log.i(Messages_parameters.mensaje_key, "Datos correctamente cargados");
                        Log.i(Messages_parameters.mensaje_key, request_volley.getResponse());
                        Deserialize_response deserialize_response=new Deserialize_response(request_volley.getResponse());
                        Log.i(Messages_parameters.mensaje_key,deserialize_response.getLst_products().get(0).getImages().get(0));
                        runOnUiThread(new Runnable() {  //actualiza el hilo principal
                            @Override
                            public void run() {
                                Products_adapter products_adapter = new Products_adapter(deserialize_response.getLst_products());
                                int resId = R.anim.layout_animation_down_to_up;
                                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
                                recyclerView.setLayoutAnimation(animation);
                                recyclerView.setAdapter(products_adapter);
                            }
                        });

                    }
                }catch (Exception ex){
                    Log.i(Messages_parameters.mensaje_key_error,"Ha ocurrido un error: "+ex.getMessage());
                }
            }
        });
        thread_response.start();
    }



}