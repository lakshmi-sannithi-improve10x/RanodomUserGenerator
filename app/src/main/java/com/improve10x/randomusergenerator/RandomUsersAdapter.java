package com.improve10x.randomusergenerator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.randomusergenerator.databinding.RandomUserItemBinding;
import com.improve10x.randomusergenerator.model.User;

import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomUserViewHolder> {
    private List<User> users;

    public void setUsers(List<User> users){
        this.users= users;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.random_user_item,parent,false);
        RandomUserViewHolder viewHolder = new RandomUserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTxt.setText(user.getName());
        holder.jobTxt.setText(user.getJob());
        holder.emailTxt.setText(user.getEmail());
        holder.incomeTxt.setText(String.valueOf(user.getIncomeUSD()));
        holder.creditScoreTxt.setText(String.valueOf(user.getCreditScore()));
        holder.addressTxt.setText(user.getAddress().getStreetAddress()+ ","+ user.getAddress().getCountry()+","+ user.getAddress().getCountryCode()+","+user.getAddress().getZipCode());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
