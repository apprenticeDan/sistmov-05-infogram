package org.sismo.infogram.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.sismo.infogram.views.ImageDetailActivity;
import org.sismo.infogram.R;
import org.sismo.infogram.models.Image;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private List<Image> images;
    private int resource;
    private Activity activity;

    public CardViewAdapter(List<Image> images, int resource, Activity activity){
        this.images = images; this.resource = resource; this.activity = activity;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resource, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Image image = images.get(position);
        //set image
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(image.getUrlImage()).into(holder.imageCardView);
        holder.usrNameCardView.setText(image.getUserName());
        holder.cantDiasCardView.setText(image.getCantidadDias());
        holder.cantLikesCardView.setText(image.getCanidadMeGusta());

        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ImageDetailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageCardView;
        private TextView usrNameCardView;
        private TextView cantDiasCardView;
        private TextView cantLikesCardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCardView = itemView.findViewById(R.id.image_cv);
            usrNameCardView = itemView.findViewById(R.id.usrName_cv);
            cantDiasCardView = itemView.findViewById(R.id.dias_cv);
            cantLikesCardView = itemView.findViewById(R.id.likes_cv);
        }
    }
}
