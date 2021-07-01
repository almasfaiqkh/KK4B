package com.xirpl4.project_kk4b.ui.profile;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.xirpl4.project_kk4b.EditProfile;
import com.xirpl4.project_kk4b.GantiPassword;
import com.xirpl4.project_kk4b.Login;
import com.xirpl4.project_kk4b.R;
import com.xirpl4.project_kk4b.ui.home.HomeViewModel;

public class ProfileFragment extends Fragment {

    TextView email, nama;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.profile_fragment, container, false);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        email = root.findViewById(R.id.text_emailProfile);
        nama = root.findViewById(R.id.text_namaProfile);

        if (user != null) {
            String fEmail = user.getEmail();
            String fNama = user.getDisplayName();

            email.setText(fEmail);
            nama.setText(fNama);
        }

        View editProfile = root.findViewById(R.id.editProfile_button);
        View ubahPassword = root.findViewById(R.id.ubahPassword_button);
        View logout = root.findViewById(R.id.logout_button);
        TextView hapusAkun = root.findViewById(R.id.hapus_akun);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });

        ubahPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GantiPassword.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });

        hapusAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(getActivity(), Login.class));
                            getActivity().finish();
                        } else {
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        return root;
    }
}
