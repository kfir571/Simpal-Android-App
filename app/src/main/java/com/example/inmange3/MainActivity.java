package com.example.inmange3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    public void onFragmentViewClick(View v) {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
//        if (fragment != null && fragment.isVisible()) {
//            if (fragment instanceof SomeFragment) {
//                ((SomeFragment) fragment).onViewClicked(v);
//            }
//        }
//    }
}
