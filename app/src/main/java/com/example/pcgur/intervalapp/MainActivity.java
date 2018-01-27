package com.example.pcgur.intervalapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.RingtonePreference;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final View mView = getLayoutInflater().inflate(R.layout.addnewitem, null);
        final EditText edt_intervallum_minutes = (EditText) mView.findViewById(R.id.edt_intervallum_minutes);
        final EditText edt_intervallum_seconds = (EditText) mView.findViewById(R.id.edt_intervallum_seconds);
        final EditText edt_korok = (EditText) mView.findViewById(R.id.edt_korok);
        final EditText edt_breaks = (EditText) mView.findViewById(R.id.edt_breaks);
        final EditText edt_name = (EditText) mView.findViewById(R.id.edt_name);
        final CheckBox chk_mentes = (CheckBox) mView.findViewById(R.id.chk_mentes);
        final Button btn_sound = (Button) mView.findViewById(R.id.btn_sound);
        final Button btn_start = (Button) mView.findViewById(R.id.btn_start);
        MediaPlayer mp;

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                felh_nev_input = new AlertDialog.Builder(MainActivity.this);
                btn_sound.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
                        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Válassz hangot!");
                        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri)null);
                        startActivity(intent);
                        try {
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }*/

                    }
                });

                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!chk_mentes.isChecked()){
                            Integer interval_minutes = Integer.parseInt(edt_intervallum_minutes.getText().toString());
                            Integer interval_seconds = Integer.parseInt(edt_intervallum_seconds.getText().toString());
                            Integer korok = Integer.parseInt(edt_korok.getText().toString());
                            Integer breaks = Integer.parseInt(edt_breaks.getText().toString());
                            String name = edt_name.getText().toString();
                            SharedPreferences sharedPreferences = getSharedPreferences("Interval", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("name", name.toString());
                            editor.putInt("korok", korok);
                            editor.putInt("breaks", breaks);
                            editor.putInt("interval_minutes", interval_minutes);
                            editor.putInt("interval_seconds", interval_seconds);
                            editor.commit();
                            Toast.makeText(MainActivity.this, "Siker", Toast.LENGTH_SHORT).show();
                            Intent start = new Intent(MainActivity.this, Counter.class);
                            startActivity(start);
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

}
