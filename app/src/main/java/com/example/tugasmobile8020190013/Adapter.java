package com.example.tugasmobile8020190013;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderSaya> {
    private Context context;
    private ArrayList motor_id, motor_merek, motor_jenis, motor_harga;
    Adapter(
            Context context,
            ArrayList motor_id,
            ArrayList motor_merek,
            ArrayList motor_jenis,
            ArrayList motor_harga
    ) {
        this.context = context;
        this.motor_id = motor_id;
        this.motor_merek = motor_merek;
        this.motor_jenis = motor_jenis;
        this.motor_harga = motor_harga;
    }

    @NonNull
    @Override
    public ViewHolderSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflaterkita = LayoutInflater.from(context);
        View viewsaya = inflaterkita.inflate(R.layout.row_saya, parent, false);
        return new ViewHolderSaya(viewsaya);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSaya holder, int position) {
        holder.txt_id_motor.setText(String.valueOf(motor_id.get(position)));
        holder.txt_merek_motor.setText(String.valueOf(motor_merek.get(position)));
        holder.txt_jenis_motor.setText(String.valueOf(motor_jenis.get(position)));
        holder.txt_harga_motor.setText(String.valueOf(motor_harga.get(position)));
        holder.layoututama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentkita = new Intent(context, Ubah.class);
                intentkita.putExtra("id",String.valueOf(motor_id.get(position)));
                intentkita.putExtra("merek",String.valueOf(motor_merek.get(position)));
                intentkita.putExtra("jenis",String.valueOf(motor_jenis.get(position)));
                intentkita.putExtra("harga",String.valueOf(motor_harga.get(position)));

                context.startActivity(intentkita);
            }
        });
    }

    @Override
    public int getItemCount() {
        return motor_id.size();
    }

    public class ViewHolderSaya extends RecyclerView.ViewHolder {

        TextView txt_id_motor, txt_merek_motor, txt_jenis_motor, txt_harga_motor;
        LinearLayout layoututama;

        public ViewHolderSaya(@NonNull View itemView) {
            super(itemView);

            txt_id_motor = itemView.findViewById(R.id.txt_motor_id);
            txt_merek_motor = itemView.findViewById(R.id.txt_motor_merek);
            txt_jenis_motor = itemView.findViewById(R.id.txt_motor_jenis);
            txt_harga_motor = itemView.findViewById(R.id.txt_motor_harga);
            layoututama = itemView.findViewById(R.id.layout_utama);
        }
    }

}
