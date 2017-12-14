package app.cigar.com.cigar.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import app.cigar.com.cigar.Activity.fragment.ProfileFragment;
import app.cigar.com.cigar.Activity.fragment.RewardPointsFragment;
import app.cigar.com.cigar.Activity.fragment.ScanFragment;
import app.cigar.com.cigar.R;
import app.cigar.com.cigar.Activity.fragment.HomeFragment;


public class HomeActivity extends AppCompatActivity {
        private DrawerLayout drawerLayout;
        private Toolbar toolbar;
    //creating app.cigar.com.cigar.Activity.fragment object
    Fragment fragment = null;
    private  FragmentTransaction ft;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
           // getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_nav_home);
            initNavigationDrawer();

        }

        public void initNavigationDrawer() {


            NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {


                    int id = menuItem.getItemId();

                    switch (id){
                        case R.id.home:
                            Toast.makeText(getApplicationContext(),"Home", Toast.LENGTH_SHORT).show();
                            fragment = new HomeFragment();
                            if (fragment != null) {
                                ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.content_frame, fragment);
                                ft.commit();
                            }
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.scan:
                            fragment = new ScanFragment();
                            if (fragment != null) {
                                ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.content_frame, fragment);
                                ft.commit();
                            }
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.rewardPoints:
                            fragment = new RewardPointsFragment();
                            if (fragment != null) {
                                ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.content_frame, fragment);
                                ft.commit();
                            }
                            Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.profile:
                                fragment = new ProfileFragment();
                            if (fragment != null) {
                                ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.content_frame, fragment);
                                ft.commit();
                            }
                            Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawers();
                            break;
                        case R.id.settings:
                            Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                            drawerLayout.closeDrawers();
                            break;

                    }
                    return true;
                }
            });

            if (fragment != null) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }

            View header = navigationView.getHeaderView(0);
            TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
            tv_email.setText("Guest, welcome");
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

/*
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

                @Override
                public void onDrawerClosed(View v){
                    super.onDrawerClosed(v);
                }

                @Override
                public void onDrawerOpened(View v) {
                    super.onDrawerOpened(v);
                }
            };
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();*/

            //create default navigation drawer toggle
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                    R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

        }

}