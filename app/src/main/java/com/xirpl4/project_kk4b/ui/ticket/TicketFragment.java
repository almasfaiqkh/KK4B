package com.xirpl4.project_kk4b.ui.ticket;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xirpl4.project_kk4b.R;
import com.xirpl4.project_kk4b.ui.search.SearchViewModel;

public class TicketFragment extends Fragment {

    private TicketViewModel mViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(TicketViewModel.class);
        View root = inflater.inflate(R.layout.ticket_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_ticket);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
