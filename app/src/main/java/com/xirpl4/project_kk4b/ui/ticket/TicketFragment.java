package com.xirpl4.project_kk4b.ui.ticket;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xirpl4.project_kk4b.DetailTiket;
import com.xirpl4.project_kk4b.R;
import com.xirpl4.project_kk4b.ui.search.SearchViewModel;

public class TicketFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ticket_fragment, container, false);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.my_toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Daftar Tiket");

        View tiket1 = root.findViewById(R.id.tiket_item1);

        tiket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DetailTiket.class));
            }
        });

        return root;
    }
}
