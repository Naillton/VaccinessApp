package com.example.vaccinessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// definindo classe adaptadora que reebera uma ista de vacinas como parametro
// A classe MyAdapter vai receber uma RecyclerView como tipo adaptador, que tera um suporte de visualizacao
class MyAdapter (val vaccineItems: ArrayList<VaccineModel>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // definindo atributos e tipos para a imagem e o texto da vacina
        var vaccineImage: ImageView
        var vaccineTitle: TextView
        var vaccineDesc: TextView

        init {
            // inicializando valores de ambos os atributos
            vaccineImage = itemView.findViewById(R.id.img)
            vaccineTitle = itemView.findViewById(R.id.txtView)
            vaccineDesc = itemView.findViewById(R.id.txtView2)

            // usando o setOnClickListener para escutar as views da nossa lista
            itemView.setOnClickListener{
                Toast.makeText(
                    itemView.context,
                    "vacina: ${vaccineItems[adapterPosition].title}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // criando layout inflater que usara o nosso layout de items,
        // passando o grupo de visualizacao principal e false para nao anexar a raiz
        // para que o meu suporte de visualizacao funcione
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_list_item,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vaccineItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // usamos o metodo onBind para vincular a view no dado correto que queremos
        holder.vaccineTitle.setText(vaccineItems[position].title)
        holder.vaccineDesc.setText(vaccineItems[position].desc)
        holder.vaccineImage.setImageResource(vaccineItems[position].img)
    }
}