package upsite.com.personalspace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by shneo on 16.03.2017.
 */

public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.MyViewHolder> {

    private static final String Tag = ".com.personalspace";
    public Context context;
    private List<UserDataModel> userDataSet;
    private View.OnClickListener mOnClickListener;


    public static class MyViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {

        public Context context;
        TextView userName;
        TextView userRate;
        ImageView userCardAvatar;
        ImageView userHeart;
        private List mList;

        public MyViewHolder(View view) {
            super(view);
            //view.setOnClickListener(this);
            this.userCardAvatar = (ImageView) view.findViewById(R.id.user_card_avatar);
            this.userHeart = (ImageView) view.findViewById(R.id.heart);
            this.userName = (TextView) view.findViewById(R.id.user_name);
            this.userRate = (TextView) view.findViewById(R.id.user_rate);
        }

       // public void setItem(String item) {
       //     item = mList.get(getAdapterPosition()).toString();
       //     Toast.makeText(context, item, Toast.LENGTH_LONG).show();
       // }

       // @Override
       // public void onClick(View v) {
       //   // String item = mList.get(getAdapterPosition()).toString();
       //   //  Toast.makeText(context, item , Toast.LENGTH_LONG).show();
       // }
    }

    public UserCardAdapter(Context context, List<UserDataModel> users) {
        this.userDataSet = users;
        this.context = context;
    }

    //public UserDataModel getIdUser(UUID id){
    //    for (UserDataModel d : userDataSet){
    //        if(d.getIdUser().equals(id))
    //            return d;
    //    }
    //    return null;
    //}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        //view.setOnClickListener(mOnClickListener);
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
