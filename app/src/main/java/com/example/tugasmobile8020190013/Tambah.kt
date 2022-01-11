package com.example.tugasmobile8020190013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Tambah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        val txtjudul = findViewById<EditText>(R.id.txt_merek)
        val txtpengarang = findViewById<EditText>(R.id.txt_jenis)
        val txthalaman = findViewById<EditText>(R.id.txt_harga)
        val btnsimpan = findViewById<Button>(R.id.smpbtn)

        btnsimpan.setOnClickListener {
            val dbsaya = MyBDhelper(this)
            dbsaya.tambahbuku(
                txtjudul.text.toString().trim(),
                txtpengarang.text.toString().trim(),
                Integer.valueOf(txthalaman.text.toString().trim())
            )
        }
    }
}
