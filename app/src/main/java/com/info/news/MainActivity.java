package com.info.news;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "https://newsapi.org/v2/everything?q=apple&from=2021-06-23&to=2021-06-23&sortBy=popularity&apiKey=0c4d13d79c2941cd8de6d1f503b04e7a";
    MyAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<NewsItem> newsItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager = new LinearLayoutManager(this);

        newsItemList = new ArrayList<>();
        loadRecyclerViewData();


    }

    private void loadRecyclerViewData() {
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {

            try {
                JSONObject Obj = new JSONObject(response);
                JSONArray array =Obj.getJSONArray("articles");
                for(int i = 0;i<array.length();i++){

                    JSONObject jsonObject = array.getJSONObject(i);
                    NewsItem newsItem = new NewsItem(jsonObject.getString("author"),jsonObject.getString("title"));
                    newsItemList.add(newsItem);
                    adapter = new MyAdapter(newsItemList, MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }, error -> {
            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
        });
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

}







