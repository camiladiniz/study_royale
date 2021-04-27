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

// define o construtor que recebe a lista de atividades e o evento de clique
class DisciplinaAdapter (
    val atividades: List<Atividade>,
    val onClick: (Atividade) -> Unit): RecyclerView.Adapter<DisciplinaAdapter.DisciplinasViewHolder>() {

    // ViewHolder com os elemetos da tela
    class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_atividades)

        }

    }

    // Quantidade de disciplinas na lista

    override fun getItemCount() = this.atividades.size

    // inflar layout do adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
        // infla view no adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_atividade, parent, false)

        // retornar ViewHolder
        val holder = DisciplinasViewHolder(view)
        return holder
    }

    fun getImagem(atividade: Atividade) {
        if(atividade.nota == 10){
            atividade.foto = "https://institutokailua.com/blog/wp-content/uploads/2018/02/z2-2.jpg"; //
        }else if(atividade.nota > 5) {
            atividade.foto = "https://i.pinimg.com/originals/57/60/47/576047f6808e70c6dee585bf790d9125.jpg"; // nota média
        }else {
            atividade.foto = "https://upload.wikimedia.org/wikipedia/pt/a/a5/Bart-gets-an-f.png"; // nota ruim
        }
    }

    // bind para atualizar Views com os dados

    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val context = holder.itemView.context

        // recuperar objeto disciplina
        val atividade = atividades[position]

        // atualizar dados de disciplina

       holder.cardNome.text = atividade.toString()
        holder.cardProgress.visibility = View.VISIBLE

        getImagem(atividade);

        Picasso.with(context).load(atividade.foto).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        // adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(atividade)}
    }
}