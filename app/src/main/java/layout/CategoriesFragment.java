package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tigerpenguin.widget.simpleratingbar.SimpleRatingBar;

import org.w3c.dom.Text;

import upsite.com.personalspace.R;
import upsite.com.personalspace.UserProfileActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {


    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;


    public CategoriesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);

        ratingBar = (RatingBar) rootView.findViewById(R.id.rating_bar_kiss);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser){
                    Toast.makeText(ratingBar.getContext(),"Your Selected Ratings  : " + String.valueOf(rating),Toast.LENGTH_LONG).show();
                }
            }
        });



        return rootView;
    }








}
