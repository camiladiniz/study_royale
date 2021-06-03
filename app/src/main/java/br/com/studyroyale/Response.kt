package br.com.studyroyale

data class Response (val sucesso:String, val msg:String) {
    // verificar se o chamada foi executada com sucesso
    fun isOK() = "true".equals(sucesso.toString(), ignoreCase = true)
}