package com.example.tugasmobile8020190013

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val motor_id : ArrayList<String> = arrayListOf()
    val motor_merek : ArrayList<String> = arrayListOf()
    val motor_jenis : ArrayList<String> = arrayListOf()
    val motor_harga : ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<FloatingActionButton>(R.id.fab_add)
        btn.setOnClickListener {
            val intentkita = Intent(this, Tambah::class.java)
            startActivity(intentkita)
        }
        simpandataarray()

        val adapter = Adapter(this, motor_id, motor_merek, motor_jenis, motor_harga)
        val rv_motor = findViewById<RecyclerView>(R.id.rv_motor)
        rv_motor.adapter = adapter
        rv_motor.layoutManager = LinearLayoutManager(this)
        rv_motor.itemAnimator = DefaultItemAnimator()
    }
    fun simpandataarray() {
        val dbSaya = MyBDhelper(this)
        val dataSaya: Cursor = dbSaya.bacasemuadata()

        if (dataSaya.count == 0)
        {
            Toast.makeText(this, " Data tidak ada ", Toast.LENGTH_SHORT).show()
        }
        else {
            while (dataSaya.moveToNext()) {
                motor_id.add(dataSaya.getString(0))
                motor_merek.add(dataSaya.getString(1))
                motor_jenis.add(dataSaya.getString(2))
                motor_harga.add(dataSaya.getString(3))
            }
        }
    }
}
