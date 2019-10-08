package com.postinfo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.postinfo.R;
import com.postinfo.model.ModelArray;
import com.postinfo.model.ModelLike;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.ViewHolder> {

private List<ModelLike> list = new ArrayList();
private LayoutInflater layoutInflater;
private Context ctx;

public LikeAdapter(Context context,List<ModelLike>model){
    this.list = model;
    this.layoutInflater =LayoutInflater.from(context);
    notifyDataSetChanged();
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.from(parent.getContext()).inflate(R.layout.recycler_liked,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        ctx = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(ctx).load(list.get(position).getAvatarImage().getUrlSmallOrigin()).apply(requestOptions).into(holder.avatarImage);
        holder.name.setText(list.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView avatarImage;
        final TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            avatarImage = itemView.findViewById(R.id.avatar_image_like);
            name = itemView.findViewById(R.id.user_name_liked);

        }
    }
}
