package br.com.studyroyale

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_nota_cadastro.*
import kotlinx.android.synthetic.main.toolbar.*


class NotaCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_cadastro)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Cadastrar Nota"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnSalvar.setOnClickListener {salvarNota()}
    }

    fun salvarNota() {

        val novaAtividade = NovaAtividade()

        val radioButtonID = atividade_rb.getCheckedRadioButtonId();
        val radioButton = atividade_rb.findViewById<RadioButton>(radioButtonID);
        val idx = atividade_rb.indexOfChild(radioButton) + 1;

        Log.d("AAAAAAAAAAAA", idx.toString())

        if(idx == 0) {
            Toast.makeText(this, "Selecione a atividade!",
                Toast.LENGTH_LONG).show()
            return;
        }

        val nomeAluno = personName.text.toString();

        if(nomeAluno == "") {
            Toast.makeText(this, "Por favor informe seu nome!",
                Toast.LENGTH_LONG).show()
            return;
        }

       val notaAluno = nota.text.toString();

        if(notaAluno == null || notaAluno == "") {
            Toast.makeText(this, "Por favor informe sua nota!",
                Toast.LENGTH_LONG).show()
            return;
        }

        novaAtividade.id = idx.toLong();
        novaAtividade.foto = "https://cdn3.iconfinder.com/data/icons/tools-trade-2-colored/48/Professionals_Tools_of_Trade_Artboard_57-512.png"
        novaAtividade.nome = nomeAluno
        novaAtividade.nota = notaAluno.toInt()

        Thread {
            AtividadeService.save(novaAtividade)
            runOnUiThread{
                finish()
            }
        }.start()

        Toast.makeText(this, "Nota salva com sucesso!",
            Toast.LENGTH_LONG).show()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
