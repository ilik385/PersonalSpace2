package upsite.com.personalspace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Ilik on 05.04.2017.
 */

public class PhotoFragment extends Fragment {

    private static ArrayList users;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;

    public PhotoFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_mediacontent, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.photo_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);


        fetchUsers();

        adapter = new UserCardAdapter(getContext(), users);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        return v;
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
