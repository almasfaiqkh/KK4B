package com.xirpl4.project_kk4b.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xirpl4.project_kk4b.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        View itemT = root.findViewById(R.id.itemintomorrow);

        itemT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DetailActivity.class));
            }
        });

        RecyclerView mRecyclerView = root.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<DataNote>();
        for (int i = 0; i < DataNoteInformation.image.length; i++) {
            data.add(
                    new DataNote
                            (
                                    DataNoteInformation.image[i],
                                    DataNoteInformation.time[i],
                                    DataNoteInformation.title[i],
                                    DataNoteInformation.subtitle[i]
                            ));
        }

        ListAdapter mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);

        return root;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private ArrayList<DataNote> dataList;

        public ListAdapter(ArrayList<DataNote> data) {
            this.dataList = data;
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
            holder.time.setText(dataList.get(position).getTime());
            holder.title.setText(dataList.get(position).getTitle());
            holder.subtitle.setText(dataList.get(position).getSubtitle());
            holder.image.setImageResource(dataList.get(position).getImage());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                  Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("IMAGES", dataList.get(position).getImage());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView time;
            TextView title;
            TextView subtitle;
            ImageView image;

            public ViewHolder(View itemView) {
                super(itemView);

                this.time = itemView.findViewById(R.id.item_txttime);
                this.title = itemView.findViewById(R.id.item_title);
                this.subtitle = itemView.findViewById(R.id.item_subtitle);
                this.image = itemView.findViewById(R.id.item_image);
            }
        }
    }
}
