package com.example.vsm1;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.vsm1.ui.Shares.HomeFragment;
import com.example.vsm1.ui.leaderboard.NotificationsFragment;
import com.example.vsm1.ui.news.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }
    private boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch (menuItem.getItemId())
        {
            case R.id.navigation_news:
                fragment = new DashboardFragment();
                break;
            case R.id.navigation_shares:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_leaderboard:
                fragment = new NotificationsFragment();
                break;

        }
        return loadFragment(fragment);

    }
}
