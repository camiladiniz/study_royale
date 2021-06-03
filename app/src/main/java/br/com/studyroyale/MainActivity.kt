package br.com.studyroyale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        botao_login.setOnClickListener {onClickLogin() }

    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()


        //if(valorUsuario != "aluno" || valorSenha != "impacta") {
        if(false){
            Toast.makeText(this, "Usuário inválido!", Toast.LENGTH_LONG).show()
        }else {
            // criar intent
            val intent = Intent(this, TelaInicialActivity::class.java)
            // colocar parâmetros (opcional)
            /*val params = Bundle()
            params.putString("nome", "Fernando Sousa")
            intent.putExtras(params)*/

            // enviar parâmetros simplificado
            /*intent.putExtra("numero", 10)*/

            // fazer a chamada
            startActivity(intent)

            // fazer a chamada esperando resultado
            /*startActivityForResult(intent, 1)*/
        }


    }
}
