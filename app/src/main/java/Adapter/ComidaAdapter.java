package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apikpro.R;

import java.util.List;

import Model.Comida;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    private List<Comida> comidas;
    private Context context;
    private View.OnClickListener listener;

    public ComidaAdapter(List<Comida> comidas, Context context) {
        this.comidas = comidas;
        this.context = context;
    }



    @NonNull
    @Override
    public ComidaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_comida,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidaAdapter.ViewHolder holder, int position) {
        holder.tv_titulo.setText(comidas.get(position).getCodigoBarra());
        holder.tv_descri.setText(comidas.get(position).getDescripcion());
        Glide.with(context).load(comidas.get(position).getUrlFoto()).into(holder.iv_portada);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }
    public  void onClick(View view){
        if(listener!= null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_portada;
        private TextView tv_titulo;
        private TextView tv_descri;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_portada=itemView.findViewById(R.id.iv_portada);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_descri = itemView.findViewById(R.id.tv_descri);


        }
    }
}
