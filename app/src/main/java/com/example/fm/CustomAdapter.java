package com.example.fm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<recruimentList> arrayList;
    private Context context;
    //어댑터에서 액티비티 액션을 가져올 때 context가 필요한데 어댑터에는 context가 X
    //선택한 액티비티에 대한 context를 가져올 때 필요

    public CustomAdapter(ArrayList<recruimentList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    //실제 리스트뷰가 어댑터에 연결된 다음, 뷰 홀더를 최초로 만들어냄
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.participant_detail3, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    //Item을 하나하나 보여줌
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.profile);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.aa.setText(arrayList.get(position).getAa());
        holder.like.setText(String.valueOf(arrayList.get(position).getLike()));
    }

    @Override
    //RecyclerView의 총 개수
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView title;
        TextView content;
        TextView aa;
        TextView like;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = itemView.findViewById(R.id.profile);
            this.title = itemView.findViewById(R.id.title);
            this.content = itemView.findViewById(R.id.content);
            this.aa = itemView.findViewById(R.id.aa);
            this.like = itemView.findViewById(R.id.like);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = arrayList.get(getAdapterPosition()).getTitle();

                    Intent intent = new Intent(v.getContext(), Paritipants_application_form_screen.class);

                    intent.putExtra("text", text);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}