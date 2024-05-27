enum class Nivel { Easy, Normal, Hard }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        // Adiciona o usuário à lista de inscritos
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso na formação $nome!")
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento de Aplicações Android", 150)
    
    // Criando uma formação
    val formacao = Formacao("Desenvolvedor Kotlin", listOf(conteudo1, conteudo2, conteudo3), Nivel.Normal)
    
    // Criando usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    // Matriculando usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    // Exibindo detalhes da formação
    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println("Conteúdos:")
    formacao.conteudos.forEach { conteudo ->
        println("- ${conteudo.nome} (${conteudo.duracao} minutos)")
    }
    
    // Exibindo usuários matriculados
    println("Usuários inscritos:")
    formacao.inscritos.forEach { inscrito ->
        println("- ${inscrito.nome}")
    }
}