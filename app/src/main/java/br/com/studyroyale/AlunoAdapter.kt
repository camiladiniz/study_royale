package br.com.studyroyale

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.studyroyale.Atividade
import com.squareup.picasso.Picasso
import  kotlinx.android.synthetic.main.adapter_atividade.*
import kotlinx.android.synthetic.main.alunos_adapter.view.*

class AlunoAdapter(private val children : List<Aluno>)
    : RecyclerView.Adapter<AlunoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.alunos_adapter,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val context = holder.itemView.context

        val child = children[position]
        //holder.imageView.setImageResource(child.foto)
        holder.textView.text = child.nome
        holder.notaView.text = "Nota: " + child.nota


                Picasso.with(context).load(child.foto).fit().into(holder.imageView,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.itemView.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.itemView.cardProgress.visibility = View.GONE
                }
            })
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.cardNome
        val imageView: ImageView = itemView.cardImg
        val notaView: TextView = itemView.cardNota

    }
}