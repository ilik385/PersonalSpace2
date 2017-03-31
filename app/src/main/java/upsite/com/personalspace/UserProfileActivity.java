package upsite.com.personalspace;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import layout.CategoriesFragment;

public class UserProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private boolean viewIsAtHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        setupMainFragment();




        /*titles = getResources().getStringArray(R.array.titles);
        drawerList = (ListView) findViewById(R.id.drawer_list);
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles));
        drawerLayout = (DrawerLayout) findViewById(R.id.user_profile_activity_drawer);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment;

                switch (position) {
                    case 0:
                        fragment = new MyRatingFragment();
                        break;
                    case 1:
                        fragment = new AccountFragment();
                        break;
                    default:
                        fragment = new MyRatingFragment();
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.activity_user_profile, fragment).commit();
                drawerLayout.closeDrawers();
            }
        });*/

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/


    }

    private void setupMainFragment() {
        MyRatingFragment mainFragment = new MyRatingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.user_profile_activity_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (!viewIsAtHome) { //if the current view is not the News fragment
            displayView(R.id.my_rating); //display the News fragment
        } else {
            moveTaskToBack(true);  //If view is in News fragment, exit application
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        displayView(menuItem.getItemId());
        return true;

    }

    public void displayView(int viewId) {

        Fragment fragment = null;

        switch (viewId) {
            case R.id.my_rating:
                fragment = new MyRatingFragment();
                viewIsAtHome = true;
                break;
            case R.id.account:
                fragment = new AccountFragment();
                viewIsAtHome = false;
                break;
            default:
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.drawer_error), Toast.LENGTH_SHORT).show();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.user_profile_activity_drawer);
        drawer.closeDrawer(GravityCompat.START);

    }

}