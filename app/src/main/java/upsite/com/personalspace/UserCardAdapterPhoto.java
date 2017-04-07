package upsite.com.personalspace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ilik on 05.04.2017.
 */

public class UserCardAdapterPhoto extends RecyclerView.Adapter<UserCardAdapterPhoto.MyViewHolderPhoto> {
    public Context context;

    private ArrayList<UserDataModelPhoto> userDataSetPhoto;

    public static class MyViewHolderPhoto extends RecyclerView.ViewHolder {

        ImageView userPhoto;

        public MyViewHolderPhoto(View view) {
            super(view);
            this.userPhoto = (ImageView) view.findViewById(R.id.user_gallery);
        }
    }

    public UserCardAdapterPhoto(Context context, ArrayList users) {
        this.userDataSetPhoto = users;
        this.context = context;
    }

    @Override
    public MyViewHolderPhoto onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_photo, parent, false);
        MyViewHolderPhoto myViewHolderPhoto = new MyViewHolderPhoto(v);

        return myViewHolderPhoto;
    }

    @Override
    public void onBindViewHolder(MyViewHolderPhoto holder, int position) {

        final ImageView imageViewUserPhoto = holder.userPhoto;

        String srcAvatar = userDataSetPhoto.get(position).getUserPhoto();

        Picasso.with(context)
                .load(R.drawable.foto_kristina)
                .placeholder(R.mipmap.ic_launcher)
                //.resize(200, 100)
                .into(imageViewUserPhoto);
    }


    @Override
    public int getItemCount(){
        return userDataSetPhoto.size();
    }
}
