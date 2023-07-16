package com.example.recyclerview_con_cardview_items.volley_request;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;

public class Request_volley {

    private Context context;
    private String response;

    public Request_volley(Context context){
        this.context=context;
        this.response= Messages_parameters.status_empty;
        getVolleyResponse();
    }


    //getters y setters

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    //**********************

    public void getVolleyResponse()
    {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest =new StringRequest(Request.Method.GET, Messages_parameters.url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                setResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setResponse(Messages_parameters.response_error);
            }
        });
        queue.add(stringRequest);
    }



}
