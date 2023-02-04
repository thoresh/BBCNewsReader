package com.example.bbcnewsreader;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DetailsActivity extends BaseActivity {

    protected DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();

        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();

        bundle.putString("title", i.getStringExtra("title"));
        bundle.putString("description", i.getStringExtra("description"));
        bundle.putString("date", i.getStringExtra("date"));
        bundle.putString("link", i.getStringExtra("link"));


        fragment.setArguments(bundle);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.baseContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}