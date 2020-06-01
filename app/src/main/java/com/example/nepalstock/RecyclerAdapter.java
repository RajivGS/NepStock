package com.example.nepalstock;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CompanyDetailList;
import com.example.OnDetailList;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;
    private OnDetailList monDetailList;

    public RecyclerAdapter(Context context, List<Object> listRecyclerItem, OnDetailList onDetailList)  {
        this.context = context;
        monDetailList = onDetailList;
        this.listRecyclerItem = listRecyclerItem;
    }

    public  class ItemViewHolder extends RecyclerView.ViewHolder  implements  View.OnClickListener{

        private TextView name;
        OnDetailList onDetailList;
        public ItemViewHolder(@NonNull View itemView, OnDetailList onDetailList) {
            super(itemView);
            this.onDetailList = onDetailList;
            name = (TextView) itemView.findViewById(R.id.companyName);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(onDetailList != null) {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    onDetailList.onItemClickDetail(position);
                }
            }
            //onDetailList.onItemClickDetail(getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE:
            default:
                View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.list_item, viewGroup, false);
                return new ItemViewHolder(layoutView,monDetailList);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        int viewType = getItemViewType(i);
        switch (viewType) {
            case TYPE:
            default:
                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                CompanyDetailList holidays = (CompanyDetailList) listRecyclerItem.get(i);
                itemViewHolder.name.setText(holidays.getCompanyName());
        }
    }
    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }

}




