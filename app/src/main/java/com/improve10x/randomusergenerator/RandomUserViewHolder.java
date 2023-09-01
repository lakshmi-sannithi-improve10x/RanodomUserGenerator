package com.improve10x.randomusergenerator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.randomusergenerator.databinding.RandomUserItemBinding;


public class RandomUserViewHolder extends RecyclerView.ViewHolder {
   public TextView nameTxt;
   public TextView jobTxt;
   public TextView emailTxt;
   public TextView  incomeTxt;
   public TextView creditScoreTxt;
   public TextView addressTxt;
    public RandomUserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        jobTxt = itemView.findViewById(R.id.job_txt);
        emailTxt = itemView.findViewById(R.id.email_txt);
        incomeTxt = itemView.findViewById(R.id.income_txt);
        creditScoreTxt = itemView.findViewById(R.id.creditscore_txt);
        addressTxt = itemView.findViewById(R.id.address_txt);

    }
}
