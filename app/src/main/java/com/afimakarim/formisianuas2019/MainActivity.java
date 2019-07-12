package com.afimakarim.formisianuas2019;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mNik;
    EditText mNama;
    Spinner mKelas;
    EditText mJam;
    Button btnSimpan;
    Button btnTampil;

    String[] kelas = {"6A", "6B", "6C", "6D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNik = findViewById(R.id.nik);
        mNama = findViewById(R.id.nama);
        mKelas = findViewById(R.id.kelas);
        mJam = findViewById(R.id.jam);
        btnSimpan = findViewById(R.id.simpan);
        btnTampil = findViewById(R.id.tampil);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, kelas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
            }
        });
    }

    private void simpanData() {
        String nik = mNik.getText().toString();
        String nama = mNama.getText().toString();
        String kelas = mKelas.getSelectedItem().toString();
        String jam = mJam.getText().toString();

        if (nik.isEmpty()) {
            mNik.setError("NIK Masih Kosong");
        } else if (nama.isEmpty()) {
            mNama.setError("Nama Masih Kosong");
        } else if (kelas.isEmpty()) {
            Toast.makeText(this, "Kelas belum di pilih", Toast.LENGTH_SHORT).show();
        } else if (jam.isEmpty()) {
            mJam.setError("Jam Masih Kosong");
        } else {
        }
    }
}
