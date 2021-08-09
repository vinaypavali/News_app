package com.info.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<NewsItem> newsItemList;
    private final Context context;

    public MyAdapter(List<NewsItem> newsItemList, Context context) {
        this.newsItemList = newsItemList;
        this.context= context;

    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_news, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        NewsItem item = newsItemList.get(position);
        holder.title.setText(item.getTitle());
        holder.author.setText(item.getAuthor());
    }

    @Override
    public int getItemCount() {

        return newsItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView title;
        public TextView author;


        public ViewHolder(View itemView) {
            super(itemView);

            title= itemView.findViewById(R.id.title1);
            author= itemView.findViewById(R.id.author1);

        }
    }
}
