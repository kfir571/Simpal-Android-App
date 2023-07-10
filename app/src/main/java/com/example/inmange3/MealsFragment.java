package com.example.inmange3;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.inmange3.adapters.MealAdapter;
import com.example.inmange3.models.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MealsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MealsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    JSONObject jsonObj;
    RecyclerView recyclerView;
    Data data = null;
    ProgressBar progressBar;
    MealAdapter adapter;
    String url = "https://www.themealdb.com/api/json/v1/1/search.php?f=b";
    View viewF;

    public MealsFragment() {
        // Required empty public constructor
        Log.d("timing","MealsFragment");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MealsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MealsFragment newInstance() {
        MealsFragment fragment = new MealsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("timing","onCreate");

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewF = inflater.inflate(R.layout.fragment_meals, container, false);
        Log.d("timing","onCreateView");

        recyclerView = viewF.findViewById(R.id.mealRecyclerView);
        progressBar = viewF.findViewById(R.id.progressBar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        if(data == null){

            progressBar.setVisibility(View.VISIBLE);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("url response:",response.toString());
                    Log.d("timing","onCreateView - onResponse");


                    try {
                        jsonObj = new JSONObject(response.toString());
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        data = gson.fromJson(String.valueOf(jsonObj), Data.class);
                        Log.d("data",data.toString());

                        adapter = new MealAdapter(getContext(),data.getMeals(),viewF,getParentFragmentManager());
                        recyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, error -> Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show());
            RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
            requestQueue.add(jsonObjectRequest);
        }
        else {
            adapter = new MealAdapter(getContext(),data.getMeals(),viewF,getParentFragmentManager());
            recyclerView.setAdapter(adapter);
        }





        return  viewF;
    }

    public void onFragmentViewClick(View view) {
        //data.getMeal(adapter.poz);
        //Navigation.findNavController(viewF).navigate(R.id.action_mealsFragment2_to_detailFragment2);
    }
}