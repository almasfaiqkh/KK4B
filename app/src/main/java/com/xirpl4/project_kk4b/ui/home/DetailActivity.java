package com.xirpl4.project_kk4b.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.xirpl4.project_kk4b.Daftar;
import com.xirpl4.project_kk4b.Payment;
import com.xirpl4.project_kk4b.R;
import com.xirpl4.project_kk4b.Splashscreen;

public class DetailActivity extends AppCompatActivity {

    ImageView imageHead;
    View btnBeli;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dialog = new Dialog(this);

        imageHead = (ImageView) findViewById(R.id.detail_image_header);

        Intent intent = getIntent();
        int imageUrl = intent.getIntExtra("IMAGES", 0);

        if (intent.hasExtra("IMAGES")) {
            imageHead.setImageResource(imageUrl);
        } else {
        }

        btnBeli = (View) findViewById(R.id.detail_footer);

        btnBeli.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Window dlg = dialog.getWindow();
                dlg.setContentView(R.layout.popup_beli);
                WindowManager.LayoutParams wlp = dlg.getAttributes();
                dlg.setWindowAnimations(R.style.DialogAnimation);
                wlp.gravity = Gravity.BOTTOM;
                dlg.setAttributes(wlp);
                dlg.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dlg.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


                final ImageView plusREG, minusREG, plusVVIP, minusVVIP;
                final TextView displayREG, displayVVIP;
                final int[] counterREG = new int[1];
                final int[] counterVVIP = new int[1];

                plusREG = (ImageView) dlg.findViewById(R.id.plusCount_tiketREG);
                minusREG = (ImageView) dlg.findViewById(R.id.minusCount_tiketREG);
                displayREG = (TextView) dlg.findViewById(R.id.count_tiketREG);

                plusVVIP = (ImageView) dlg.findViewById(R.id.pluscount_tiketVVIP);
                minusVVIP = (ImageView) dlg.findViewById(R.id.minuscount_tiketVVIP);
                displayVVIP = (TextView) dlg.findViewById(R.id.count_tiketVVIP);

                counterREG[0] = 0;

                plusREG.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        minusREG.setImageResource(R.drawable.ei_minus);
                        counterREG[0] = counterREG[0] + 1;
                        displayREG.setText("" + counterREG[0]);
                    }
                });

                minusREG.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (counterREG[0] > 1) {
                            counterREG[0] = counterREG[0] - 1;
                            displayREG.setText("" + counterREG[0]);
                        } else if (counterREG[0] == 1) {
                            minusREG.setImageResource(R.drawable.ei_minus_transparent);
                            counterREG[0] = counterREG[0] - 1;
                            displayREG.setText("" + counterREG[0]);
                        }
                    }
                });


                plusVVIP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        minusVVIP.setImageResource(R.drawable.ei_minus);
                        counterVVIP[0] = counterVVIP[0] + 1;
                        displayVVIP.setText("" + counterVVIP[0]);
                    }
                });

                minusVVIP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (counterVVIP[0] > 1) {
                            counterVVIP[0] = counterVVIP[0] - 1;
                            displayVVIP.setText("" + counterVVIP[0]);
                        } else if (counterVVIP[0] == 1) {
                            minusVVIP.setImageResource(R.drawable.ei_minus_transparent);
                            counterVVIP[0] = counterVVIP[0] - 1;
                            displayVVIP.setText("" + counterVVIP[0]);
                        }
                    }
                });

                View pembayaran;

                pembayaran = (View) dlg.findViewById(R.id.pembayaran_button);

                pembayaran.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Payment.class));
                    }
                });
            }
        });
    }
}

