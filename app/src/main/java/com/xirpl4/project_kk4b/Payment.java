package com.xirpl4.project_kk4b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class Payment extends AppCompatActivity {

    View btn_bayar;
    CardView pBank, pOvo, pAlfamart;
    TextView tBank, tOvo, tAlfamart;
    ImageView iBank, cBank, cOvo, cAlfamart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Payment");

        pBank = (CardView) findViewById(R.id.payment_bank);
        pOvo = (CardView) findViewById(R.id.payment_ovo);
        pAlfamart = (CardView) findViewById(R.id.payment_alfamart);

        tBank = (TextView) findViewById(R.id.text_bank);
        tOvo = (TextView) findViewById(R.id.text_ovo);
        tAlfamart = (TextView) findViewById(R.id.text_alfamart);

        iBank = (ImageView) findViewById(R.id.img_bank);

        cBank = (ImageView) findViewById(R.id.ceklist_bank);
        cOvo = (ImageView) findViewById(R.id.ceklist_ovo);
        cAlfamart = (ImageView) findViewById(R.id.ceklist_alfamart);

        pBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pBank.setCardBackgroundColor(getResources().getColor(R.color.Blue_default_app));
                pOvo.setCardBackgroundColor(getResources().getColor(R.color.white));
                pAlfamart.setCardBackgroundColor(getResources().getColor(R.color.white));

                tOvo.setTextColor(getResources().getColor(R.color.black));
                cOvo.setVisibility(View.INVISIBLE);

                tAlfamart.setTextColor(getResources().getColor(R.color.black));
                cAlfamart.setVisibility(View.INVISIBLE);

                iBank.setImageResource(R.drawable.bank);
                tBank.setTextColor(getResources().getColor(R.color.white));
                cBank.setVisibility(View.VISIBLE);
            }
        });

        pOvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pBank.setCardBackgroundColor(getResources().getColor(R.color.white));
                pOvo.setCardBackgroundColor(getResources().getColor(R.color.Blue_default_app));
                pAlfamart.setCardBackgroundColor(getResources().getColor(R.color.white));

                iBank.setImageResource(R.drawable.bank_black);
                tBank.setTextColor(getResources().getColor(R.color.black));
                cBank.setVisibility(View.INVISIBLE);

                tAlfamart.setTextColor(getResources().getColor(R.color.black));
                cAlfamart.setVisibility(View.INVISIBLE);

                tOvo.setTextColor(getResources().getColor(R.color.white));
                cOvo.setVisibility(View.VISIBLE);
            }
        });

        pAlfamart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pBank.setCardBackgroundColor(getResources().getColor(R.color.white));
                pOvo.setCardBackgroundColor(getResources().getColor(R.color.white));
                pAlfamart.setCardBackgroundColor(getResources().getColor(R.color.Blue_default_app));

                iBank.setImageResource(R.drawable.bank_black);
                tBank.setTextColor(getResources().getColor(R.color.black));
                cBank.setVisibility(View.INVISIBLE);

                tOvo.setTextColor(getResources().getColor(R.color.black));
                cOvo.setVisibility(View.INVISIBLE);

                tAlfamart.setTextColor(getResources().getColor(R.color.white));
                cAlfamart.setVisibility(View.VISIBLE);
            }
        });

        btn_bayar = (View) findViewById(R.id.bayar_button);

        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Payment.this, Succespay.class));
                finish();
            }
        });
    }
}
