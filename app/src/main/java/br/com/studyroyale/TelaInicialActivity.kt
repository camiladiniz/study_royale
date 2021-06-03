package br.com.studyroyale

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var atividades = listOf<Atividade>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // colocar toolbar
        setSupportActionBar(toolbar)

//        btn_item1.setOnClickListener{clickButton(btn_item1)}
//
//        btn_item2.setOnClickListener{clickButton(btn_item2)}
//
//        btn_item3.setOnClickListener{clickButton(btn_item3)}

        // configuração no menu lateral
        configuraMenuLateral()

        // configurar cardview
        recyclerAtividades?.layoutManager = LinearLayoutManager(context)
        recyclerAtividades?.itemAnimator = DefaultItemAnimator()
        recyclerAtividades?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        // task para recuperar as disciplinas
        taskAtividades()
    }

    fun taskAtividades() {
        // Criar a Thread

        Thread {
            // Código para procurar as disciplinas
            // que será executado em segundo plano / Thread separada
            this.atividades = AtividadeService.getAtividades(context)
            runOnUiThread {
                // Código para atualizar a UI com a lista de disciplinas
                recyclerAtividades?.adapter = DisciplinaAdapter(this.atividades) { onClickAtividade(it) }
            }
        }.start()
    }

    fun onClickAtividade(atividade: Atividade) {

//        if(atividade.nota < 5) {
//            Toast.makeText(context, "Parece que você precisa estudar mais", Toast.LENGTH_SHORT)
//                .show()
//        }else if(atividade.nota == 10) {
//            Toast.makeText(context, "Parabéns! Continue assim", Toast.LENGTH_SHORT)
//                .show()
//        }else {
//            Toast.makeText(context, "Muito bem!", Toast.LENGTH_SHORT)
//                .show()
//        }

    }

    // configuração do navigation Drawer com a toolbar
    private fun configuraMenuLateral() {

        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }

    // método que deve ser implementado quando a activity implementa
    // a interface NavigationView.OnNavigationItemSelectedListener
    // para tratar os eventos de clique no menu lateral
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_atividades -> {
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_cadastrar_atividade -> {
                val intent = Intent(this, NotaCadastroActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_sair -> {
                Toast.makeText(this, "Até a próxima!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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

//            progressBar.visibility = View.VISIBLE
//            Handler().postDelayed(
//                {
//                    progressBar.visibility = View.INVISIBLE
//                },
//                10000
//            )

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
