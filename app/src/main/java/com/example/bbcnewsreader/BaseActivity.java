package com.example.bbcnewsreader;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        setNavigationDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.activity_home) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.activity_favorite) {
            Toast.makeText(this.getBaseContext(), "Will be implemented", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.activity_help) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("1. Fetch News Feeds from BBC site on Home Page.\n" +
                                "2. Select News Feed Item to view details.\n" +
                                "3. Add to the Favorite news items (Max 100).\n" +
                                "4. View All your Favorite news feeds.\n" +
                                "5. Select A favorite News feed to view its details.\n"+
                                "6. Delete a Favorite News Feed");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();


            return true;
        }

        if (id == R.id.activity_close) {
            finishAffinity();
            System.exit(0);
            return true;
        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu_items, menu);
        return true;
    }

    protected void setNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle
                (
                        this,
                        drawerLayout,
                        R.string.open,
                        R.string.close
                )
        {
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if(itemId == R.id.nav_exit) {
                    finishAffinity();
                    System.exit(0);
                } else if(itemId == R.id.nav_home) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                } else if(itemId == R.id.nav_favorite) {
                    Toast.makeText(getBaseContext(), "Will be implemented", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}