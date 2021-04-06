package br.com.studyroyale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
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
