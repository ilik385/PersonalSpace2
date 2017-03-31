package upsite.com.personalspace;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.CategoriesFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRatingFragment extends Fragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public MyRatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_my_rating, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar_user);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout_user);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ContactsFragment(), "Contacts");
        adapter.addFragment(new CategoriesFragment(), "Categories");
        //adapter.addFragment(new CategoriesFragment(), "хули не работаешь");
        viewPager.setAdapter(adapter);
    }

}
