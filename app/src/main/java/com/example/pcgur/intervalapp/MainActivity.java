package com.example.pcgur.intervalapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.addnew) FloatingActionButton addnew;
    private AlertDialog.Builder felh_nev_input;
    private PostsDatabaseHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                felh_nev_input = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.addnewitem, null);
                final EditText edt_intervallum = (EditText) mView.findViewById(R.id.edt_intervallum);
                final EditText edt_korok = (EditText) mView.findViewById(R.id.edt_korok);
                final EditText edt_breaks = (EditText) mView.findViewById(R.id.edt_breaks);
                final EditText edt_name = (EditText) mView.findViewById(R.id.edt_name);
                final CheckBox chk_mentes = (CheckBox) mView.findViewById(R.id.chk_mentes);
                Button btn_start = (Button) mView.findViewById(R.id.btn_start);
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!chk_mentes.isChecked()){
                            Integer interval = Integer.parseInt(edt_intervallum.getText().toString());
                            Integer korok = Integer.parseInt(edt_korok.getText().toString());
                            Integer breaks = Integer.parseInt(edt_breaks.getText().toString());
                            String name = edt_name.getText().toString();

                            try {
                            Boolean resoult = mydb.adatRogzites(interval, korok, breaks, name);
                                Toast.makeText(MainActivity.this, "Adatrögzítés sikeres!", Toast.LENGTH_SHORT).show();

                            }catch(Exception e){
                                Toast.makeText(MainActivity.this, "Adatrögzítés sikertelen!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });


                felh_nev_input.setView(mView);
                final AlertDialog dialog = felh_nev_input.create();
                //dialog.setCancelable(cancelable);
                dialog.show();
            }
        });

    }
    private void adatFelvetel(){

    }
}
