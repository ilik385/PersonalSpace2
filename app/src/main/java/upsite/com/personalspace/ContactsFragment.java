package upsite.com.personalspace;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {

    private static final String TAG = "site.personalspace.TAG";
    public static final int EXTRA_DATE = 1;
    public static final String EXTRA_CONTACT_ID = "PersonalSpace2.CONTACT_ID";
    private static final String REQUEST_DATA_ID = "upsite.com.personalspace";
    private static List<UserDataModel> users;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    Context context;
    //ArrayList mUserDataModel = new ArrayList<UserDataModel>();




    //public static ContactsFragment newInstance(UUID contactId) {
   //    Bundle args = new Bundle();
   //    args.putSerializable(EXTRA_CONTACT_ID, contactId);

   //    ContactsFragment fragment = new ContactsFragment();
   //    fragment.setArguments(args);

   //    return fragment;
   //}




    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
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
        //final long id = recyclerView.getChildItemId(rootView);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), AnotherUserActivity.class);
                getActivity().startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                try {
                    //если бы нужно было сделать через ArrayList, то потребовалось бы "прокастить" вызваный объект
                    String  y = String.valueOf(users.get(position).userName);

                    Intent intent = new Intent(getActivity(), UserMediaContentPageActivity.class);
                    intent.putExtra(EXTRA_CONTACT_ID, y);
                    getActivity().startActivityForResult(intent, EXTRA_DATE);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    //Toast.makeText(getActivity().getApplicationContext(), y , Toast.LENGTH_SHORT).show();
                }catch(Exception e) {
                    Log.e(TAG, "Error intent", e);
                    Toast.makeText(getContext(),"не вышло передать интент", Toast.LENGTH_SHORT).show();
                    }
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
        users.add(new UserDataModel("foto_natali_jpg", "Natali", "3.8", "ic_like_filled"));
        users.add(new UserDataModel("foto_kristina", "Kristina", "4.1", "ic_like_empty"));
        users.add(new UserDataModel("foto_user_profile", "Alex", "2.6", "ic_like"));
        users.add(new UserDataModel("foto_natali_jpg", "Marina", "2.9", "ic_like"));
        users.add(new UserDataModel("foto_kristina", "Marina", "2.9", "ic_like"));
        users.add(new UserDataModel("foto_user_profile", "Marina", "2.9", "ic_like"));
    }

}
