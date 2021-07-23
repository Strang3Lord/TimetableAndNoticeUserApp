package com.example.timetable.NoticeFeed;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetable.R;
import com.example.timetable.Second;


import java.util.List;


public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {

    private Context context;
    private List<uploadPDF> list;

    public PdfAdapter(Context context, List<uploadPDF> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PdfViewHolder(LayoutInflater.from(context).inflate(R.layout.notice_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, final int position) {

        holder.noticename.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Notice_VIewer.class);
                intent.putExtra("uri",list.get(position).getUri());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PdfViewHolder extends RecyclerView.ViewHolder {

        private TextView noticename;
        private ImageView download;


        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);
            noticename = itemView.findViewById(R.id.noticename);
            download = itemView.findViewById(R.id.downlaod);
        }
    }
}
