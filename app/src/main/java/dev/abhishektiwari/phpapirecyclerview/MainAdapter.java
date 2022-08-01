package dev.abhishektiwari.phpapirecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    Context context;
    ArrayList<Model> models;

    public MainAdapter(Context context, ArrayList<Model> models)  {
        this.context = context;
        this.models =models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(models.get(position).getId());
        holder.name.setText(models.get(position).getName());
        holder.email.setText(models.get(position).getEmail());
        holder.post.setText(models.get(position).getPost());

    }

    @Override
    public int getItemCount() {
        return models.size( );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,email,post;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            post = itemView.findViewById(R.id.post);
        }
    }
}

