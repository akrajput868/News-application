package com.myapp.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import com.myapp.newsapplication.multile_frame.About;
import com.myapp.newsapplication.multile_frame.Dislike_news;
import com.myapp.newsapplication.multile_frame.Like_news;
import com.myapp.newsapplication.multile_frame.Login;
import com.myapp.newsapplication.multile_frame.Terms;
import com.myapp.newsapplication.multile_frame.home;
import com.myapp.newsapplication.multile_frame.profile;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private NavigationView navView;
    private Toolbar toolbar;
    private TextView txtTitle;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        try {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navView.setNavigationItemSelectedListener(this);
            navView.setItemIconTintList(null);
            toolbar.setVisibility(View.VISIBLE);

            View v = navView.getHeaderView(0);
            TextView txtName = (TextView)v.findViewById(R.id.txtName);
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(MainActivity.this, Login_activity.class);
                    startActivity(in);
                }
            });

            setFm(new home());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCreate() {
    }

    private void setFm(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_frame, fragment).addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            finish();
        }
        else {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedFragment(item.getItemId());
        return true;
    }

    private void displaySelectedFragment(int menuItemId) {
        Fragment fragment = null;
        if (menuItemId == R.id.nav_home) {
            txtTitle.setText("Home");
            fragment = new home();
            setFm(fragment);
        }
        else if (menuItemId == R.id.nav_profile) {
            txtTitle.setText("My Profile");
            fragment=new profile();
            setFm(fragment);
            //fragment = new FmMyOrders();
        }
        else if (menuItemId == R.id.nav_like) {
            txtTitle.setText("Like News");
            fragment=new Like_news();
            setFm(fragment);
            //fragment = new FmMyAccounts();
        }
        else if (menuItemId == R.id.nav_dislike) {
            txtTitle.setText("Dislike News");
            fragment=new Dislike_news();
            setFm(fragment);
            //fragment = new FmPrivacyPolicy();
        }
        else if (menuItemId == R.id.nav_about) {
            txtTitle.setText("About!");
            fragment=new About();
            setFm(fragment);
        }
        else if (menuItemId == R.id.nav_term) {
            txtTitle.setText("Terms & Condtion");
            fragment=new Terms();
            setFm(fragment);
        }
        else if (menuItemId == R.id.nav_login) {
            txtTitle.setText("Login/Logout");
            fragment=new Login();
            setFm(fragment);
        }
        //replace the current fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_frame, fragment).addToBackStack(null);
            ft.commit();
        }

        drawer.closeDrawer(GravityCompat.START);
    }


    private void logout(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Alert!!");
        alertDialogBuilder.setMessage("Are you sure want to Logout the app!");
        //null should be your on click listener
        alertDialogBuilder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = alertDialogBuilder.create();
        mDialog.show();
    }
}