package com.afimakarim.formisianuas2019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afimakarim.formisianuas2019.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class UasAdapter extends RecyclerView.Adapter<UasAdapter.MyHolder> {
    private Context context;
    private List<DataItem> data = new ArrayList<>();

    public UasAdapter(Context context, List<DataItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvNik.setText(data.get(position).getNik());
        holder.tvNama.setText(data.get(position).getNama());
        holder.tvKelas.setText(data.get(position).getKelas());
        holder.tvJam.setText(data.get(position).getJam());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNik;
        TextView tvNama;
        TextView tvKelas;
        TextView tvJam;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvNik = itemView.findViewById(R.id.tv_nik);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKelas = itemView.findViewById(R.id.tv_kelas);
            tvJam = itemView.findViewById(R.id.tv_jam);
        }
    }
}
