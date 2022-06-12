package com.example.apdoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.apdoan.fragment.fragment_favorite;
import com.example.apdoan.fragment.fragment_home;
import com.example.apdoan.fragment.fragment_new;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;
    private final static int FRAGMENT_HOME = 0;
    private final static int FRAGMENT_FAVORITE = 1;
    private final static int FRAGMENT_NEW = 2;
    private int mCurrentFragment = FRAGMENT_HOME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.nav_open, R.string.nav_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new fragment_home());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new fragment_home());
                mCurrentFragment = FRAGMENT_HOME;
            }
        } else if(id == R.id.nav_favorite){
            if(mCurrentFragment != FRAGMENT_FAVORITE){
                replaceFragment(new fragment_favorite());
                mCurrentFragment = FRAGMENT_FAVORITE;
            }
        } else if(id == R.id.nav_new){
            if(mCurrentFragment != FRAGMENT_NEW){
                replaceFragment(new fragment_new());
                mCurrentFragment = FRAGMENT_NEW;
            }
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

private void replaceFragment(Fragment fragment){
    FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fame_layout, fragment);
    fragmentTransaction.commit();

}
}