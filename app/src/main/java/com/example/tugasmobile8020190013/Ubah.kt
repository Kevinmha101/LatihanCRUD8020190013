package com.example.tugasmobile8020190013

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Ubah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah)

        val actionBar = supportActionBar
        if(intent.hasExtra("merek")){
            actionBar?.title = intent.getStringExtra("merek")
        }

        getintentdata()

        val btnubah = findViewById<Button>(R.id.editbtn)

        btnubah.setOnClickListener{
            val dbkita = MyBDhelper(this)

            val idmotor = intent.getStringExtra("id")
            val merekmotor = findViewById<EditText>(R.id.txt_edit_merek).text.toString()
            val jenismotor = findViewById<EditText>(R.id.txt_edit_jenis).text.toString()
            val hargamotor = findViewById<EditText>(R.id.txt_edit_harga).text.toString()
            dbkita.ubahmotor(idmotor,merekmotor,jenismotor,hargamotor)
        }

        val btndelete = findViewById<Button>(R.id.btnhapus)
        btndelete.setOnClickListener{
            dialogkinfirmasi()
        }
    }
    fun getintentdata(){
        if(
            intent.hasExtra("id")&&intent.hasExtra("merek")&&intent.hasExtra("jenis")
            &&intent.hasExtra("harga")
        )
        {
            val idmotor = intent.getStringExtra("id")
            val merekmotor = intent.getStringExtra("merek")
            val jenismotor = intent.getStringExtra("jenis")
            val hargamotor = intent.getStringExtra("harga")

            val editmerekmotor = findViewById<EditText>(R.id.txt_edit_merek)
            val editjenismotor = findViewById<EditText>(R.id.txt_edit_jenis)
            val edithargamotor = findViewById<EditText>(R.id.txt_edit_harga)
        }
        else{
            Toast.makeText(this,"data tidak ada",Toast.LENGTH_SHORT).show()
        }
    }
    fun dialogkinfirmasi(){
        val idmotor = intent.getStringExtra("id")
        val merekmotor = intent.getStringExtra("merek")

        val alertsDialog = AlertDialog.Builder(this)
        alertsDialog.setTitle("Delete " + merekmotor +" ?")
        alertsDialog.setMessage("Apakah data ini ingin dihapus" +merekmotor+" ?")
        alertsDialog.setPositiveButton("iya",DialogInterface.OnClickListener{dialog, which ->
            val dbkita = MyBDhelper(this)
            dbkita.hapusbuku(idmotor)
            startActivity(Intent(this,MainActivity::class.java))
        })
        alertsDialog.setNegativeButton("tidak",DialogInterface.OnClickListener{dialog, which ->
           alertsDialog.create().show()
        })
    }
}