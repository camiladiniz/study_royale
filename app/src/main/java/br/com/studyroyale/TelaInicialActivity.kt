package br.com.studyroyale

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // colocar toolbar
        setSupportActionBar(toolbar)

        btn_item1.setOnClickListener{clickButton(btn_item1)}

        btn_item2.setOnClickListener{clickButton(btn_item2)}

        btn_item3.setOnClickListener{clickButton(btn_item3)}

    }

    fun clickButton(button: Button) {

        supportActionBar?.title = button.text.toString()

    }

    // função sobrescrita para inflar o menu na ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)

        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                showMessage(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                showMessage(query)
                return false
            }

        })
        return true
    }

    fun showMessage(text: String) {
        Toast.makeText(this, text,
            Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem
        //Toast na tela
        // a comparação é feita com o recurso de id definido no xml
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Botão de buscar",
                Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {

            progressBar.visibility = View.VISIBLE
            Handler().postDelayed(
                {
                    progressBar.visibility = View.INVISIBLE
                },
                10000
            )

        } else if (id == R.id.action_criar) {

            val intent = Intent(this, NotaCadastroActivity::class.java)
            startActivity(intent)

        }
        else if (id == R.id.action_config) {

            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)

            // botão up navigation
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
