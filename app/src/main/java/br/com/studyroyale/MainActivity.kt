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

        // procurar pelas preferências, se pediu para guardar usuário e senha
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            campo_usuario.setText(lembrarNome)
            campo_senha.setText(lembrarSenha)
            checkLembrar.isChecked = lembrar

        }
    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()


        //if(valorUsuario != "aluno" || valorSenha != "impacta") {
        if(false){
            Toast.makeText(this, "Usuário inválido!", Toast.LENGTH_LONG).show()
        }else {
            // armazenar valor do checkbox
            Prefs.setBoolean("lembrar", checkLembrar.isChecked)
//          // verificar se é para lembrar nome e senha
            if (checkLembrar.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else{
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha","")
            }

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
