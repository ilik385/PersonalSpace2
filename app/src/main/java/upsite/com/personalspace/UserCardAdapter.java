package upsite.com.personalspace;

import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by shneo on 16.03.2017.
 */

public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.MyViewHolder> {
    public Context context;

    private ArrayList<UserDataModel> userDataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView userRate;
        ImageView userCardAvatar;
        ImageView userHeart;

        public MyViewHolder(View view) {
            super(view);
            this.userCardAvatar = (ImageView) view.findViewById(R.id.user_card_avatar);
            this.userHeart = (ImageView) view.findViewById(R.id.heart);
            this.userName = (TextView) view.findViewById(R.id.user_name);
            this.userRate = (TextView) view.findViewById(R.id.user_rate);
        }

    }

    public UserCardAdapter(Context context, ArrayList users) {
        this.userDataSet = users;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final TextView textViewUserName = holder.userName;
        final TextView textViewUserRate = holder.userRate;
        final ImageView imageViewUserCardAvatar = holder.userCardAvatar;
        final ImageView imageViewUserHeart = holder.userHeart;

        textViewUserName.setText(userDataSet.get(position).getUserName());
        textViewUserRate.setText(userDataSet.get(position).getUserRate());

        String srcAvatar = userDataSet.get(position).getUserCardAvatar();

        Picasso.with(context)
                .load(R.drawable.foto_natali_jpg)
                .placeholder(R.mipmap.ic_launcher)
                //.resize(200, 100)
                .into(imageViewUserCardAvatar);

        Picasso.with(context)
                .load(R.drawable.ic_like_filled)
                .into(imageViewUserHeart);
    }


    @Override
    public int getItemCount(){
        return userDataSet.size();
    }

}
