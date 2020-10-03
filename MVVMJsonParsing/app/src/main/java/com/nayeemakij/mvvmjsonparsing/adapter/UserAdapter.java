package com.nayeemakij.mvvmjsonparsing.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nayeemakij.mvvmjsonparsing.Model.User;
import com.nayeemakij.mvvmjsonparsing.R;
import com.squareup.picasso.Picasso;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textView.setText(users[position].getLogin());
        holder.textView1.setText("Id: "+String.valueOf(users[position].getId()));
        holder.textView2.setText(users[position].getUrl());

        Picasso.get().load(users[position].getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, textView1, textView2;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.userImage);
            textView= itemView.findViewById(R.id.userName);
            textView1= itemView.findViewById(R.id.userId);
            textView2= itemView.findViewById(R.id.userUrl);
        }
    }
}
