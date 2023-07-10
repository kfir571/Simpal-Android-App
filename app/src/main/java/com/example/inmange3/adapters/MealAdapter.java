package com.example.inmange3.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inmange3.R;
import com.example.inmange3.models.Meals;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealViewHolder> {
    private Context context;
    private List<Meals> data;
    private View viewF;
    private FragmentManager fragmentManager;


    //public int poz = 0;


    public MealAdapter(Context context, List<Meals> data, View viewF,FragmentManager fragmentManager) {
        this.context = context;
        this.data = data;
        this.viewF = viewF;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load((data.get(position).getStrMealThumb())).into(holder.mealImage);

        holder.mealImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {


//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragmentContainerView, new Fragment(R.layout.fragment_detail));
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();


                // poz=position;
                Navigation.findNavController(viewF).navigate(R.id.action_mealsFragment2_to_detailFragment2);
               // Log.d("poz",poz+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class MealViewHolder extends RecyclerView.ViewHolder{
    CardView mealCard;
    ImageView mealImage;

    public MealViewHolder(@NonNull View itemView) {
        super(itemView);
        mealCard=itemView.findViewById(R.id.itemCard);
        mealImage = itemView.findViewById(R.id.imageCard);
    }
}