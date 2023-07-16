package com.example.recyclerview_con_cardview_items.deserialize;

import android.util.Log;

import com.example.recyclerview_con_cardview_items.messages.Messages_parameters;
import com.example.recyclerview_con_cardview_items.model.Products;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Deserialize_response {

    private String response;
    private List<Products> lst_products;

    public Deserialize_response(String response){
        this.response=response;
        lst_products=new ArrayList<Products>();
        try {
            deserialize_json();
        }catch (Exception ex){
            Log.i(Messages_parameters.mensaje_key_error,ex.getMessage());
        }
    }

    private void deserialize_json() throws JSONException {
        List<Products> lst_product_aux=new ArrayList<Products>();
        Products products;
        JSONArray jsonArray= new JSONObject(getResponse()).getJSONArray("products");
        for(Integer x=0;x<jsonArray.length();x++)
        {
            JSONObject jsonObject=jsonArray.getJSONObject(x);
            products=new Products();
            products.setId(jsonObject.getString("id"));
            products.setTitle(jsonObject.getString("title"));
            products.setDescription(jsonObject.getString("description"));
            products.setPrice(jsonObject.getString("price"));
            products.setDiscount_percentage(jsonObject.getString("discountPercentage"));
            products.setRating(jsonObject.getString("rating"));
            products.setStock(jsonObject.getString("stock"));
            products.setBrand(jsonObject.getString("brand"));
            products.setCategory(jsonObject.getString("category"));
            products.setThumbnail(jsonObject.getString("thumbnail"));
            //***
            List<String> images=new ArrayList<String>();
            JSONArray images_array=jsonObject.getJSONArray("images");
            for(Integer i=0;i<images_array.length();i++)
                images.add(images_array.getString(i));
            products.setImages(images);
            lst_product_aux.add(products);
        }
        setLst_products(lst_product_aux);
        Log.i(Messages_parameters.mensaje_key,"Datos deserealizados correctamente");
    }


    //getters y setters
    public List<Products> getLst_products() {
        return lst_products;
    }

    public void setLst_products(List<Products> lst_products) {
        this.lst_products = lst_products;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
