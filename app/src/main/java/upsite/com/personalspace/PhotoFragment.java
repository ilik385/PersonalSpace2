package upsite.com.personalspace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        adapter = new UserCardAdapterPhoto(getContext(), users);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "picture", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        return v;
    }

    public void fetchUsers() {
        users = new ArrayList();

        users.add(new UserDataModelPhoto("0", 1));
        users.add(new UserDataModelPhoto("1", 2));
        users.add(new UserDataModelPhoto("0", 1));
        users.add(new UserDataModelPhoto("1", 2));
        users.add(new UserDataModelPhoto("0", 1));
        users.add(new UserDataModelPhoto("1", 2));
        users.add(new UserDataModelPhoto("0", 1));
        users.add(new UserDataModelPhoto("1", 2));
    }



}
