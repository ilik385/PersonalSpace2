package upsite.com.personalspace;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {

    private static ArrayList users;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;


    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        fetchUsers();

        adapter = new UserCardAdapter(getContext(), users);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), AnotherUserActivity.class);
                getActivity().startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));


        return rootView;
    }

    public void fetchUsers() {
        users = new ArrayList();


        users.add(new UserDataModel("foto_natali_jpg", "Natali", "3.8", "ic_like_filled"));
        users.add(new UserDataModel("foto_kristina", "Kristina", "4.1", "ic_like_empty"));
        users.add(new UserDataModel("foto_user_profile", "Alex", "2.6", "ic_like"));
        users.add(new UserDataModel("foto_natali_jpg", "Marina", "2.9", "ic_like"));
        users.add(new UserDataModel("foto_kristina", "Marina", "2.9", "ic_like"));
        users.add(new UserDataModel("foto_user_profile", "Marina", "2.9", "ic_like"));
    }

}
