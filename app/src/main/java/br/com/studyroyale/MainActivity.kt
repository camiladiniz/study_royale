package br.com.studyroyale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
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

        var validAuth = true

        Thread {
            // Código para procurar as disciplinas
            // que será executado em segundo plano / Thread separada
            val response = AtividadeService.autenticar(valorUsuario, valorSenha)

            //if(valorUsuario != "aluno" || valorSenha != "impacta") {
            if(!response.isOK()){
                validAuth = false
            }

            runOnUiThread {
                if(!validAuth){
                    Toast.makeText(this, "Usuário inválido!", Toast.LENGTH_LONG).show()
                }else {
                    authenticateWithSuccess(valorUsuario, valorSenha)
                }
            }
        }.start()

    }

    fun authenticateWithSuccess(usuario: String, senha: String) {
// armazenar valor do checkbox
        Prefs.setBoolean("lembrar", checkLembrar.isChecked)
//          // verificar se é para lembrar nome e senha
        if (checkLembrar.isChecked) {
            Prefs.setString("lembrarNome", usuario)
            Prefs.setString("lembrarSenha", senha)
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
