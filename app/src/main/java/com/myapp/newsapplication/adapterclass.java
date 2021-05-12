package com.myapp.newsapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class adapterclass extends RecyclerView.Adapter<adapterclass.Holder> {

    private List<News.Article> list = new ArrayList<>();
    Context context;
    private onClick onClickEvent;

    public adapterclass(Context context, List<News.Article> list, onClick onClickEvent) {
        this.list=list;
        this.context=context;
        this.onClickEvent=onClickEvent;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapterclass, parent, false);
        return new adapterclass.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        News.Article val = list.get(position);

        holder.txt1.setText(""+val.getTitle());
        holder.txt2.setText(""+val.getDescription());


        Glide.with(context)
                .load(val.getUrlToImage())
                .into(holder.img1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private TextView txt1,txt2;
        private ImageView img1;
        private Button butt1;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txt1=(TextView) itemView.findViewById(R.id.txt1);
            txt2=(TextView) itemView.findViewById(R.id.txtDescription);
            img1=(ImageView) itemView.findViewById(R.id.img1);
            butt1=(Button) itemView.findViewById(R.id.buttReadMore);

            butt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickEvent.itemClick(list.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface onClick{
        public void itemClick(News.Article item);
    }
}