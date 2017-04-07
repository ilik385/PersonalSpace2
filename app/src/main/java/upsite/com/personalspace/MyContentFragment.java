package upsite.com.personalspace;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



/**
 * Created by Ilik on 03.04.2017.
 */

public class MyContentFragment extends Fragment {

    public static final int EXTRA_DATE = 1;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ArrayList users;
    private ViewPager viewPager;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;



   //public MyContentFragment(){

   //}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        String s = getActivity().getIntent().getStringExtra(ContactsFragment.EXTRA_CONTACT_ID);
        getActivity().setTitle(s);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mediacontent, container, false);

        //getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar = (Toolbar)v.findViewById(R.id.toolbar_media);
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        viewPager = (ViewPager)v.findViewById(R.id.view_photopager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tab_layout_user_content);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new PhotoFragment(), "Photo");
        adapter.addFragment(new VideoFragment(), "Video");
        adapter.addFragment(new NotesFragment(), "Notes");
        viewPager.setAdapter(adapter);
    }

}
